package project;

/* 
 * @author: Iman Alshaiba & Kaltham Alemadi
 * @version: 1.0
 * @since 23-4-2026
 * edit and add method 24-4-2026
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages the visa office system.
 * It stores applicants, officers, and applications, and provides methods
 * to add, search, display, process, and save visa data.
 */
public class VisaOfficeSystem {
	Scanner in = new Scanner(System.in);

	// List of all visa applications
	public ArrayList<Application>applications = new ArrayList<>();

	// List of all visa officers
	public ArrayList<Officer>officers = new ArrayList<>();

	// List of all applicants
	public ArrayList<Applicant>applicants = new ArrayList<>();

	// Counter used to generate application numbers
	public  int application_counter =1000;

	// Counter used to generate officer IDs
	public int officer_counter = 2000;

	// Data manager used to load and save data
	public DataManager dm = new DataLoader();

	/**
	 * Adds a new visa officer to the system.
	 * @param newOfficer officer to be added
	 */
	public void addVisaOfficer(Officer newOfficer) {
		officers.add(newOfficer);
	}

	/**
	 * Adds a new visa application to the system.
	 * @param app application to be added
	 */
	public void addApplication(Application app) {
		applications.add(app);
	}

	/**
	 * Adds a new applicant to the system.
	 * @param app applicant to be added
	 */
	public void addApplicant(Applicant app) {
		applicants.add(app);
	}

	/**
	 * Displays all officers in the system.
	 */
	public void displayAllOfficers() {
		for(Officer f : officers) {
			System.out.println(f);
		}
	}

	/**
	 * Assigns an officer to a visa application.
	 * @param app application to assign
	 * @param officer officer assigned to the application
	 */
	public void assignOfficerToApplication(Application app, Officer officer) {
		app.setOfficer(officer);
	}

	/**
	 * Finds an application by application number.
	 * @param appNo application number
	 * @return application if found, otherwise null
	 */
	public Application findApplicationByApplicationNo(int appNo) {
		for(Application a: applications) {
			if(a.getApplicationNO()==appNo) {
				return a;
			}
		}
		return null;
	}

	/**
	 * Finds an officer by officer ID.
	 * @param officerId officer ID
	 * @return officer if found, otherwise null
	 */
	public Officer findOfficerByID(int officerId) {
		for(Officer f: officers) {
			if(f.getId()== officerId) {
				return f;
			}
		}
		return null;
	}

	/**
	 * Finds an applicant by passport number.
	 * @param passportNo passport number
	 * @return applicant if found, otherwise null
	 */
	public Applicant findApplicantByPassportNo(String passportNo) {
		for(Applicant ap : applicants) {
			if(ap.getPassportNO().equalsIgnoreCase(passportNo)) {
				return ap;
			}
		}
		return null;
	}

	/**
	 * Displays all applications in the system.
	 */
	public void viewAllApplicantions() {
		for(Application a: applications) {
			System.out.println(a.toString());
		}
	}

	/**
	 * Removes an application by application number.
	 * @param appNo application number to remove
	 */
	public void removeApplication(int appNo) {
		for(int i =0; i<applications.size(); i++) {
			if(applications.get(i).getApplicationNO()== appNo) {
				applications.remove(i);
				return;
			}
		}
	}

	/**
	 * Updates the status of an application.
	 * @param app application to process
	 * @param status new status
	 */
	public void processApplication(Application app, Status status) {
		app.setStatus(status);
	}

	/**
	 * Displays applications assigned to a specific officer.
	 * @param officerID officer ID
	 */
	public void displayAssignedApplications(int officerID) {
		for(Application a: applications) {
			if(a.getOfficer().getId()== officerID) {
				System.out.println(a);
			}
		}
		System.out.println("Invalid Officer");
	}

	/**
	 * Displays one application in tabular format.
	 * @param a application to display
	 */
	public void displayApplicationTabular(Application a) {
		if( a== null || a.getApplicant() == null) {
			System.out.println("Invaild applicant");
			return ;
		}

		String officerName = (a.getOfficer() == null) ? "N/A" : a.getOfficer().getName();
	    String visaType = a.getClass().getSimpleName();

	    System.out.println("\t"+
	        a.getApplicationNO() + "\t" +
	        a.getApplicant().getName() + "\t" +
	        a.getApplicant().getPassportNO() + "\t" +
	        a.getApplicant().getNationality() + "\t"+
	        a.getStatus() + "\t"+
	        a.getSubmissionDate() + "\t" +
	        visaType + "\t" +
	        officerName );
	}

	/**
	 * Displays a list of applications in tabular format.
	 * @param app list of applications to display
	 */
	public void displayApplicationTabular(ArrayList<Application> app) {
	    System.out.println("Application No\tApplicant Name\tPassport No.\tNationality\tStatus\tSubmission Date\tVisa Type\tOfficer");

	    for (Application a : app) {
	    	 displayApplicationTabular(a);
	    }
	}

	/**
	 * Displays all pending applications.
	 */
	public void displayPendingApplications() {
		for(Application a: applications) {
			if(a.getStatus()==Status.PENDING) {
				System.out.println(a);
			}
		}
	}

	/**
	 * Calculates the total revenue from all applications.
	 * @return total revenue
	 */
	public double calculateTotalRevenue() {
	    double total = 0;

	    for (Application app : applications) {
	        total += app.calculateProcessingFee();
	    }

	    return total;
	}

	/**
	 * Finds and displays the applicant with the most applications.
	 */
	public void calculateWithMostApplications() {
		 Applicant maxApplicant = null;
	        int maxCount = 0;

	        for (Applicant a : applicants) {
	            int count = 0;

	            for (Application app : applications) {
	                if (app.getApplicant().equals(a)) {
	                    count++;
	                }
	            }

	            if (count > maxCount) {
	                maxCount = count;
	                maxApplicant = a;
	            }
	        }

	        if (maxApplicant != null) {
	            System.out.println("Top Applicant: " + maxApplicant.getName() + " (" + maxCount + " applications)");
	        }
	}

	/**
	 * Displays applications submitted before or on a specific date.
	 * @param date date used for filtering applications
	 */
	public void displayApplicationsBeforeDate( LocalDate date) {
		 for (Application app : applications) {
	            if (!app.getSubmissionDate().isAfter(date)) {
	                System.out.println(app);
	                System.out.println("----------------------");
	            }
	        }
	}

	/**
	 * Saves applicants, officers, and applications into files.
	 */
	public void save() {
		if (dm instanceof DataLoader) {
		        DataLoader dl = (DataLoader) dm;
		        dl.saveApplicants(applicants);
		        dl.saveOfficers(officers);
		        dl.saveApplications(applications);
		 }
	}
}
}
