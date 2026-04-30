package project;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

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
		        	 sc.nextInt();
		             switch (choice) { 
		                 case 1: 
		                     showAdminMenu(sys, sc); 
		                     break; 
		 
		                 case 2: 
		                     showOfficerMenu(sys); 
		                     break; 
		 
		                 case 3: 
		                     showApplicantMenu(); 
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
			if(option==1) {
				System.out.println("Enter Officer Name: ");
				System.out.println("Officer        is successfully added to the system. ");
			}
			else if(option==2) {
				System.out.println("--- Available Officers ---");
				sys.displayAllOfficers();
				
			}
			else if(option==3) {
				System.out.println("Enter Officer ID: ");
				System.out.println("Select one of the visa applications below ");
				System.out.println("Enter Visa Application No: ");
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
		public static void showOfficerMenu(VisaOfficeSystem sys ) { 
		  // TODO Handle officer menu 
			System.out.println("------Officer Login------");
			System.out.println(sys.);
		} // End of showOfficerMenu method 
		public static void showApplicantMenu() { 
		  // TODO Handle applicant menu 
			System.out.println("------Applicant Login------");
		} // End of showApplicantMenu method 
		
		
		 
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

	


