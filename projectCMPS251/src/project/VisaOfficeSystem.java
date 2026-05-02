package project;
/* 
 * @author: Iman Alshaiba & Kaltham Alemadi
 * @ version: 
 * @ since 23-4-2026
 * edit and add method 24-4-2026
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class VisaOfficeSystem {
	Scanner in = new Scanner(System.in);
	public ArrayList<Application>applications = new ArrayList<>();
	public ArrayList<Officer>officers = new ArrayList<>();
	public ArrayList<Applicant>applicants = new ArrayList<>();
	public  int application_counter =1000;
	public int officer_counter = 2000;
	DataManager dm = new DataLoader();

	//public VisaOfficeSystem() { }
	
	public void addVisaOfficer(Officer newOfficer) {
		officers.add(newOfficer);
	}
	public void addApplication(Application app) {
		applications.add(app);
	}
	public void addApplicant(Applicant app) {
		applicants.add(app);
	}

	public void displayAllOfficers() {
		for(Officer f : officers) {
			System.out.println(f);
		}

	}
	public void assignOfficerToApplication(Application app, Officer officer) {
		app.setOfficer(officer);


	}
	public Application findApplicationByApplicationNo(int appNo) {
		for(Application a: applications) {
			if(a.getApplicationNO()==appNo) {
				return a;
			}
			
		}
		return null;

	}
	public Officer findOfficerByID(int officerId) {
		
		for(Officer f: officers) {
			if(f.getId()== officerId) {
				return f;
			}
		}
		return null;

	}
	public Applicant findApplicantByPassportNo(String passportNo) {
		for(Applicant ap : applicants) {
			if(ap.getPassportNO().equalsIgnoreCase(passportNo)) {
				return ap;
			}
		}
		return null;

	}
	public void viewAllApplicantions() {
		for(Application a: applications) {
			System.out.println(a.toString());
		}

	}

	public void removeApplication(int appNo) {
		for(int i =0; i<applications.size(); i++) {
			if(applications.get(i).getApplicationNO()== appNo) {
				applications.remove(i);
				return;
			}
		}
	}

	public void processApplication(Application app, Status status) {
		app.setStatus(status);

	}
	public void displayAssignedApplications(int officerID) {
		for(Application a: applications) {
			if(a.getOfficer().getId()== officerID) {
				System.out.println(a);
			}
		}
		System.out.println("Invalid Officer");
		
	}
	
	public void displayApplicationTabular(Application a) {
		
		String officerName = (a.getOfficer() == null) ? "N/A" : a.getOfficer().getName();
	    String visaType = a.getClass().getSimpleName();


	    System.out.println(
	        a.getApplicationNO() + "\t" +
	        a.getApplicant().getName() + "\t" +
	        a.getApplicant().getPassportNO() + "\t" +
	        a.getApplicant().getNationality() + "\t" +
	        a.getStatus() + "\t" +
	        a.getSubmissionDate() + "\t" +
	        visaType + "\t" +
	        officerName );
	}
	
	public void displayApplicationTabular(ArrayList<Application> app) {

	    System.out.println("Application No\tApplicant Name\tPassport No.\tNationality\tStatus\tSubmission Date\tVisa Type\tOfficer");

	    for (Application a : app) {

	    	 displayApplicationTabular(a);
	    }
	}
	
	public void displayPendingApplications() {
		for(Application a: applications) {
			if(a.getStatus()==Status.PENDING) {
				System.out.println(a);
			}
		}

	}
	
	public double calculateTotalRevenue() {

	    double total = 0;

	    for (Application app : applications) {
	        total += app.calculateProcessingFee();
	    }

	    return total;
	}
	
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

	
	public void displayApplicationsBeforeDate( LocalDate date) {
		 for (Application app : applications) {
	            if (!app.getSubmissionDate().isAfter(date)) {
	                System.out.println(app);
	                System.out.println("----------------------");
	            }
	        }
	}
	
	public void save() {
		if (dm instanceof DataLoader) {
		        DataLoader dl = (DataLoader) dm;
		        dl.saveApplicants(applicants);
		        dl.saveOfficers(officers);
		        dl.saveApplications(applications);
		 }
	}
}
