import java.util.Scanner;

public class clinicManagement {
	public static void main(String[] args) throws Exception {
		Scanner info = new Scanner(System.in); // Created a object in 'info' in Scanner
        ClearScreen.cls();
		// code for the calender
		while (true) {
			ClearScreen.cls();
			System.out.println("\t\t\t\t\t\tHospital Clinic\n\n");
			System.out.println("\t\t\t\t\t\tMain Page\t\t\t\t\t\t\t");
			System.out.println(calendar.date());
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"               1.Patient                         2.Doctor                   3.recepetnist               ");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------");

			System.out.print("Please select the number as per the user : "); // Giving the user the option to select
			int select_no = info.nextInt();
			// This is for the the user to input for selecting the options from above

			switch (select_no) {
				case 1:
					while (select_no == 1) {
						Patient.p_main();
						System.out.print("Do you want to continue in Patient section?(Y/N) : ");
						char ch = info.next().charAt(0);
						if (ch == 'N')
							break;
					}
					break;

				case 2:
				    ClearScreen.cls();
					System.out.println("Enter doctor name and id");
					String Name = info.next();
					int Id = info.nextInt();
					Doctor d = new Doctor();
					if (d.getName().equals(Name)) {
						if (d.getId() == Id)
							Doctor.patientReport();
					} else
						System.out.println("Incorrect id or password");
					break;

				case 3:
                    ClearScreen.cls();
					System.out.println("Enter receptionist ID and name");
					int id = info.nextInt();
					String name = info.next();
					Receptionist r = new Receptionist();
					if (r.getId() == id && r.getname().equals(name)) {
						Receptionist.Rmain();
					}
					else{
						System.out.println("Incorrect ID or Password");
					}

					break;

				default:
					System.out.println("Please re-check the given input \n Thankyou");
			}
			System.out.print("Do you want to continue in the main section....(Y/N) : ");
			char c = info.next().charAt(0);
			if (c == 'N')
				break;
		}
	}

}
