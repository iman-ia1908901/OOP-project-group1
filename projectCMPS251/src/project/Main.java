package project;


import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Sarah Alhajri & Iman Alshaiba & Kaltham Alemadi
 * 
 * @version Version
 * @since 2026-04-27/ fixed 2026-4-30
 * 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VisaOfficeSystem sys = new VisaOfficeSystem();
	//  TODO Load data from files 
		
		try {    
		int choice = 0; 
		 
		         do { 
		        	 //  TODO Show main menu 
		        	 
		        	 System.out.println("=== Welcome to Qatar Visa Processing System ===");
		        	 System.out.println("1. Admin");
		        	 System.out.println("2. Officer");
		        	 System.out.println("3. Applicant");
		        	 System.out.println("0. Save & Exit");
		        	 
		        	 //  TODO Take user selection 
		        	 System.out.println("Enter menu option: ");
		        	 choice = sc.nextInt();
		             switch (choice) { 
		                 case 1: 
		                     showAdminMenu(sys, sc); 
		                     break; 
		 
		                 case 2: 
		                     showOfficerMenu(sys,sc); 
		                     break; 
		 
		                 case 3: 
		                	 showApplicantMenu(sys, sc); 
		                     break; 
		 
		                 case 0: 
		                     // TODO Save data in files  
		                     System.out.println("Exiting system..."); 
		                     System.exit(0); 
		 
		                 default: 
		                     System.out.println("Invalid option"); 
		             } 
		 
		         } while (true); 
		     } catch (InputMismatchException e) { 
		            System.out.println("Invalid entry type! Enter an integer between 0 and 3."); 
		     } 
		 
		} // End of main method 
		public static void showAdminMenu(VisaOfficeSystem sys, Scanner sc) { 
		  // TODO Handle admin menu 
			System.out.println("--------------------------------------");
			System.out.println("1. Add Visa Officer");
			System.out.println("2. Display All Officers");
			System.out.println("3. Assign Officer to Application");
			System.out.println("4. View All Applications");
			System.out.println("5. Remove Application ");
			System.out.println("6. Generate Reports");
			System.out.println("0. Back to Main Menu");
			
			
			
			System.out.println("Enter menu option: ");
			int option= sc.nextInt();
			sc.nextLine();
			if(option==1) {
				System.out.println("Enter Officer Name: ");
				String name = sc.nextLine();
				int id = sys.officer_counter++;
				Officer f = new Officer(id,name);  
				sys.addVisaOfficer(f);
				System.out.println("Officer "+ f.getName() + "  is successfully added to the system. ");
			}
			else if(option==2) {
				System.out.println("--- Available Officers ---");
				sys.displayAllOfficers();
				
			}
			else if(option==3) {
				System.out.println("Enter Officer ID: ");
				int idOf = sc.nextInt();
				sys.findOfficerByID(idOf);
				System.out.println("Select one of the visa applications below ");
				sc.nextLine();
				System.out.println("Enter Visa Application No: ");
				int appNo = sc.nextInt();
				sys.findApplicationByApplicationNo(appNo);
				sys.assignOfficerToApplication(null, null);
				System.out.println("Application    has been assigned to officer    Successfully");
				
			}
			else if(option==4) {
				sys.viewAllApplicantions();
				
			}
			else if(option==5) {
				System.out.println("Select one of the visa applications below ");
				sys.viewAllApplicantions();
				System.out.println("Enter Visa Application No: ");
				System.out.println("Application    removed Successfully");
				
			}
			else if(option==6) {
				System.out.println("-- Reports --");
				System.out.println(" 1) Display pending applications");
				System.out.println(" 2) Calculate total revenue");
				System.out.println(" 3) Find applicant with most applications");
				System.out.println(" 4) Display applications before a specific date");
				System.out.println(" 0) Back ");
				
				System.out.println(" Enter option number: ");
				int reOption = sc.nextInt();
				if(reOption==1) {
					sys.displayPendingApplications();
				}
				if(reOption==2) {
					
				}
				if(reOption==3) {
					System.out.println(" Applicant with most applications is   ");
					sys.calculateWithMostApplications();
					
				}
				if(reOption==4) {
					System.out.println(" Enter date [yyy-mm-dd]: ");
				}
				
			}
			else if(option==0) {
				
				
			}	
			
			
			
		} // End of showAdminMenu method 
		public static void showOfficerMenu(VisaOfficeSystem sys, Scanner sc) { 
		  // TODO Handle officer menu 
			System.out.println("------Officer Login------");
			sys.displayAllOfficers();
			System.out.println("Enter Office ID to login: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("-- Welcome "+sys.findOfficerByID(id).getName() +"--\n");
			System.out.println("1. View Assigned Applications");
			System.out.println("2. Review Application Details");
			System.out.println("3. process Application");
			System.out.println("4. Calculate Processing Fee");
			System.out.println("0. Back to Main Menu");
			
			System.out.println("Enter menu option: ");
			int option= sc.nextInt();
			sc.nextLine();
			if(option==1) {
				System.out.println("Assigned Applications: ");
				sys.displayAssignedApplications(id);
			}
			
			if(option==2) {
				System.out.println("Enter application number: ");
				int num = sc.nextInt();
				sc.nextLine();
				System.out.println("Application No: ");
				System.out.println("Application info:  ");
				System.out.println("Status: ");
				System.out.println("SubmissionDate: ");
				System.out.println("Officer: ");
				System.out.println("Visa Type: ");
				System.out.println("Univ: ");
			}
			
			
		} // End of showOfficerMenu method 
		public static void showApplicantMenu(VisaOfficeSystem sys,  Scanner sc) { 
		  // TODO Handle applicant menu 
			System.out.println("------Applicant Login------");
			System.out.println(sys.applicants);
			System.out.println("1. Existing Applicant");
	        System.out.println("2. New Applicant");

	        System.out.println("Enter option No.: ");
			int option= sc.nextInt();
			
			Applicant applicant = null;
			
			if(option==1) {
				System.out.print("Enter Passport Number: ");
	            String passport = sc.nextLine();

	            applicant =
	                    sys.findApplicantByPassportNo(passport);

	            if (applicant == null) {

	                System.out.println("Applicant not found.");
	                return; 
	            }
			}
			 else if (option == 2) {

		            System.out.print("Enter Name: ");
		            String name = sc.nextLine();

		            System.out.print("Enter Passport Number: ");
		            String passport = sc.nextLine();

		            System.out.print("Enter Nationality: ");
		            String nationality = sc.nextLine();

		            System.out.print("Enter Birthdate [yyyy-mm-dd]: ");

		            LocalDate birthdate =
		                    LocalDate.parse(sc.nextLine());

		            applicant = new Applicant(name, passport, nationality, birthdate);

		            sys.addApplicant(applicant);

		            System.out.println("Applicant added successfully.");

		        }
			
			 else {
		            System.out.println("Invalid option");
		            return;
		        }
			
			System.out.println("1. Create Visa Application");
		    System.out.println("2. View My Applications");
		    System.out.println("3. Check Application Status");
		    System.out.println("4. Withdraw Application");
	        System.out.println("0. Back");

	        System.out.print("Enter menu option: ");
	        
	        int choice = sc.nextInt();
	        sc.nextLine();

	        if (choice == 1) {

	            System.out.println("1. Tourist Visa");
	            System.out.println("2. Student Visa");
	            System.out.println("3. Work Visa");

	            int visaChoice = sc.nextInt();
	            sc.nextLine();

	            int appNo = ++sys.application_counter;

	            Application app = null;
	            
	            if (visaChoice == 1) {

	                System.out.print("Enter duration days: ");
	                int days = sc.nextInt();
	                sc.nextLine();

	                System.out.print("Hotel reservation (true/false): ");
	                boolean hotel =
	                        Boolean.parseBoolean(sc.nextLine());

	                app = new TouristVisa(appNo, applicant, Status.PENDING, LocalDate.now(), null, days, hotel);
	            }
	            else if (visaChoice == 2) {

	                System.out.print("Enter university name: ");
	                String uni = sc.nextLine();

	                System.out.print("Enter study duration: ");
	                int years = sc.nextInt();
	                sc.nextLine();

	                System.out.print("Scholarship (true/false): ");
	                boolean scholarship =
	                        Boolean.parseBoolean(sc.nextLine());

	                app = new StudentVisa(appNo, applicant, Status.PENDING, LocalDate.now(), null, uni, years, scholarship);

	            }
	            else if (visaChoice == 3) {

	                System.out.print("Enter company name: ");
	                String company = sc.nextLine();

	                System.out.print("Enter salary: ");
	                double salary = sc.nextDouble();
	                sc.nextLine();

	                System.out.print("Enter contract duration: ");
	                int duration = sc.nextInt();
	                sc.nextLine();

	                app = new WorkVisa(appNo, applicant, Status.PENDING, LocalDate.now(), null, company, salary, duration);

	            }
	            if (app != null) {

	                sys.addApplication(app);

	                System.out.println("Application submitted successfully.");

	            }
	        }
	        else if (choice == 2) {

	        	boolean found = false;

	        	for (Application app : sys.applications) {

	        	    if (app.getApplicant().getPassportNO().equalsIgnoreCase(applicant.getPassportNO())) {

	        	        System.out.println(app);
	        	        System.out.println("----------------------");
	        	        found = true;
	        	    }
	        	}

	        	if (!found) {
	        	    System.out.println("No applications found.");
	        	}

	        }
	        else if (choice == 3) {

	            System.out.print("Enter Application Number: ");

	            int appNo = sc.nextInt();
	            sc.nextLine();

	            Application app =
	                    sys.findApplicationByApplicationNo(appNo);

	            if (app == null) {

	                System.out.println("Application not found.");

	            }

	            else {

	                System.out.println("Status = "
	                        + app.getStatus());

	            }

	        }
	        else if (choice == 4) {

	            System.out.print("Enter Application Number: ");

	            int appNo = sc.nextInt();
	            sc.nextLine();

	            sys.removeApplication(appNo);

	        }

	    }
 

		
		
		
		
		// End of showApplicantMenu method 
		
		
		 
	       /* Applicant applicant1 = new Applicant("Sara", "P111", "Qatar", LocalDate.of(2004, 5, 10));
	        Officer officer1 = new Officer(2001, "Ali");

	        system.addApplicant(applicant1);
	        system.addVisaOfficer(officer1);

	        System.out.println("=== Visa Office System Test ===");
	        System.out.println("Applicant added:");
	        System.out.println(applicant1);

	        System.out.println();

	        System.out.println("Officer added:");
	        System.out.println(officer1);

	        System.out.println();

	        system.save();

	        System.out.println("Testing completed successfully.");*/
	    }

	
