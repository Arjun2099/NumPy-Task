import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


class Helper extends ObjectOutputStream {

  Helper() throws IOException {
    super();
  }

  Helper(OutputStream o) throws IOException {
    super(o);
  }

  public void writeStreamHeader() throws IOException {
    return;
  }
}

public class Patient implements Serializable {
  int p_Id; // id of the patient
  String p_Name; // name of the patient
  int p_Age; // age of the patient
  long p_Phone; // phone of the patient
  String p_Address; // Home address of the patient
  String p_Sex; // sex of the patient
  long p_Pass;
  String p_Problem;

  static Scanner p_info = new Scanner(System.in);

  Patient(int id, String name, int age, String gender, long phone, String address, long password, String problem) {

    this.p_Id = id;
    this.p_Name = name;
    this.p_Age = age;
    this.p_Phone = phone;
    this.p_Address = address;
    this.p_Sex = gender;
    this.p_Pass = password;
    this.p_Problem = problem;

  }

  Patient() {

  }

  

  static void new_Patient() throws Exception {

    System.out.println("--------------------------------------------------------------------------------");
    System.out.println("                     **NEW PATIENT SECTION**");
    System.out.println("--------------------------------------------------------------------------------");
    System.out.println(" ");

    System.out.print(" Name of the patient : ");
    String name = p_info.next();
    System.out.println();

    System.out.print("ID of the patient : ");
    int id = p_info.nextInt();
    System.out.println();

    System.out.print("Age of the patient : ");
    int age = p_info.nextInt();
    System.out.println();

    System.out.print("Gender : ");
    String gender = p_info.next();
    System.out.println();

    System.out.print("Phone number : ");
    long phone = p_info.nextLong();
    System.out.println();

    System.out.print("Address of the patient : ");
    String address = p_info.next();
    System.out.println();

    System.out.print("4 digit password : ");
    long password = p_info.nextLong();
    System.out.println();

    System.out.print("Problems faced by the patient : ");
    String problem = p_info.next();
    System.out.println();

    Patient p = new Patient(id, name, age, gender, phone, address, password, problem);

    File F = new File("Patient.txt");

    FileOutputStream fo = new FileOutputStream(F, true);

    if (F.length() == 0) {
      ObjectOutputStream obj = new ObjectOutputStream(fo);
      obj.writeObject(p);
      obj.close();
    } else {
      Helper h = new Helper(fo);
      h.writeObject(p);
      fo.close();
    }

  }

  

  public String toString() {
    return this.p_Id + "  " + this.p_Name + "   " + this.p_Sex + "  " + this.p_Age + "   " + this.p_Phone + "    "
        + this.p_Address;
  }

  static void login_Patient() throws Exception {

    System.out.print("Enter your p_Id : ");
    int id = p_info.nextInt();
    System.out.println();
    System.out.print("Enter your password : ");
    long password = p_info.nextLong();
    System.out.println();

    File F = new File("Patient.txt");
    FileInputStream fi = new FileInputStream(F);
    ObjectInputStream oi = new ObjectInputStream(fi);

    int flag = 0;
    Patient P = null;
    while (fi.available() != 0) {
      P = (Patient) oi.readObject();

      if (P.p_Id == id) {
        flag = 1;
        break;
      }
    }
    if (flag == 0)
      System.out.println("Patient is not registered. Kindly goto new Patient section and register");
    else {
      if (P.p_Pass == password) {
          File f = new File("PatientReport.txt");
          FileInputStream Fi = new FileInputStream(f);
          Scanner Sc = new Scanner(Fi);
          while(Sc.hasNext()){
            String line = Sc.nextLine();
            System.out.println(line);
          } 
          System.out.println("\n\n");
          Sc.close();
      }
    }
  }


  static void paybill() throws Exception{
    System.out.print("Enter your name : ");
        String name = p_info.next();
        System.out.print("Do you want to pay the bill? (Y/N) : ");
        char pb = p_info.next().charAt(0);
        if(pb == 'Y'){
          File f = new File(name+".txt");
          FileOutputStream fo = new FileOutputStream(f,true);
          PrintWriter pw = new PrintWriter(fo);
          pw.println("\n\n\t\t\t Bill status : Paid");
          System.out.println("Bill paid");
          pw.close();
          fo.close();
        }
        else{
          File f = new File(name+".txt");
          FileOutputStream fo = new FileOutputStream(f,true);
          PrintWriter pw = new PrintWriter(fo);
          pw.println("\n\n\t\t\t Bill status : Not paid");
          System.out.println("Bill not paid");
          pw.close();
          fo.close();
        }
  }


  public static void p_main() throws Exception {
    ClearScreen.cls();
    System.out.println("--------------------------------------------------------------------------------");
    System.out.println("                     **PATIENT SECTION**                                        ");
    System.out.println("--------------------------------------------------------------------------------");

    System.out.println("1.New patient\n2.Login\n3.Pay bill");
    int p_Option = p_info.nextInt();
    ClearScreen.cls();

    switch (p_Option) {
      case 1:
        new_Patient();
        break;

      case 2:
        login_Patient();
        break;

      case 3:
        paybill();
        break;

     
    }

  }

}
