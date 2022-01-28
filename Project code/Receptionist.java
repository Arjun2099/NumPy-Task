import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

public class Receptionist extends Patient {
    private String name = "Benjamin";
    private int Recep_id = 2255;

    public Receptionist() {
        // To remove the error while running
    }

    public String getname() {
        return this.name;
    }

    public int getId() {
        return this.Recep_id;
    }

    static void view_pList() throws Exception {
        ClearScreen.cls();

        File F = new File("Patient.txt");
    
        if (F.length() != 0) {
          Patient P = null;
    
          FileInputStream fi = new FileInputStream(F);
          ObjectInputStream oi = new ObjectInputStream(fi);
    
          while (fi.available() != 0) {
            P = (Patient) oi.readObject();
            System.out.println(P);
            System.out.println();
          }
          oi.close();
          fi.close();
        }
    
      }

    static void Rmain() throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("                     *** Receptionist Section ***                                        ");
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("1.Billing\n2.appointment\n3.view patient list");
        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                File f = new File("Patient.txt");

                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);

                System.out.print("Enter Name of the patient : ");
                String Name = sc.next();

                int flag = 0;

                while (fi.available() != 0) {
                    Patient pat = (Patient) oi.readObject();

                    if(pat.p_Name.equals(Name)){
                        flag=1;
                        System.out.print("Enter the bill amount : ");
                        Double amount = sc.nextDouble();
                        File bill = new File(Name + ".txt");
                        FileOutputStream fo = new FileOutputStream(bill);
                        PrintWriter pw = new PrintWriter(fo);
                        pw.println(
                            "------------------------------------------------------------------------------------------------");
                    pw.println(
                            "                       ****** HOSPITAL CLINIC ******                                                  ");
                    pw.println();
                    pw.println(
                            "                    ****** MEDICAL BILL RECEIPT ******                                                   ");
                    pw.println(
                            "------------------------------------------------------------------------------------------------");
                    pw.println(calendar.date());
                    pw.println("\n\n\n\t\t\t Patient name : "+ Name);
                    pw.println("\n\n\t\t\t Total amount : "+amount);
                    pw.close();
                    }
                      
                }
                if(flag==0){
                    System.out.println("Patient not registered");
                }

                fi.close();
                break;

            case 2:

                File reportfile = new File("PatientReport.txt");
                FileOutputStream fo = new FileOutputStream(reportfile);
                PrintWriter pw1 = new PrintWriter(fo);
                FileInputStream rfi = new FileInputStream("Patient.txt");
                ObjectInputStream ois = new ObjectInputStream(rfi);

                System.out.println("Enter patient name: ");
                String name = sc.next();
                int flag1 = 0;
                while (rfi.available() != 0) {
                    Patient P = (Patient) ois.readObject();
                    if (P.p_Name.equals(name)) {
                        flag1 = 1;
                        pw1.println(
                                "------------------------------------------------------------------------------------------------");
                        pw1.println("\n");
                        pw1.println(
                                "                       ******* PATIENT REPORT *******                                                  ");
                        pw1.println("\n");
                        pw1.println(
                                "------------------------------------------------------------------------------------------------");
                        pw1.println(calendar.date());
                        pw1.println("\n\n\n\t\t\t\t Patient Name : " + name);
                        pw1.println("\n\t\t\t\t Patient age : " + P.p_Age);
                        pw1.println("\n\t\t\t\t Patient gender : " + P.p_Sex);
                        pw1.println("\n\t\t\t\t Patient phone : " + P.p_Phone);
                        pw1.println("\n\t\t\t\t Patient adress : " + P.p_Address);
                        pw1.println("\n\t\t\t\t Patient problem : " + P.p_Problem);
                        pw1.close();
                    }
                }
                if (flag1 == 0)
                    System.out.println("Patient not registered");
                
                break;
            
                case 3:
                  view_pList();
                  break;
            
                default :
                  System.out.println("Enter from the provided options only");

        }
    }
}
