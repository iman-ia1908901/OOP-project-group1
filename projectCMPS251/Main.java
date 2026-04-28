package project;

import java.time.LocalDate;

public class Main {


	public static void main(String[] args) {
		 VisaOfficeSystem system = new VisaOfficeSystem();

	        Applicant applicant1 = new Applicant("Sara", "P111", "Qatar", LocalDate.of(2004, 5, 10));
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

	        System.out.println("Testing completed successfully.");
	    }

	}


