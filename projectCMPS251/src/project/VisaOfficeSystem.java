package project;
/* 
 * @author: Iman Alshaiba 
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
	public int application_counter = 1000;
	public int officer_counter = 2000;
	DataManager dm = new DataLoader();

	public VisaOfficeSystem() {

	}
	public void addVisaOfficer(Officer newOfficer) {
		officers.add(newOfficer);
	}
	public void addApplicaion(Application app) {
		applications.add(app);
	}
	public void addApplicant(Applicant app) {
		applicants.add(app);
	}

	public void displayAllOfficers() {
		for(Officer f : officers) {
			System.out.println(f.toString());
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
		applications.remove(appNo);
	}

	public void processApplication(Application app, Status status) {
		app.setStatus(status);

	}
	public void displayAssignedApplications(int officerID) {
		for(Application a: applications) {
			if(a.getOfficer().getId()== officerID) {
				System.out.println(a);
			}
			else {
				System.out.println("invaild officer id");
			}

				
			}
		}


	public void displayApplicationTabular(Application a) {
		System.out.println("Application No  Applicant Name   passport No.  Nationality "
				+ "Status   Submission Date   Visa Type   Officer");
		System.out.println(a.getApplicationNO()+"\n"+a.getApplicant().getName()+"\n"+a.getApplicant().getPassportNO()+"\n"
				+a.getApplicant().getNationality()+"\n"+a.getStatus()+"\n"+a.getSubmissionDate()+
				"\n"+a.getOfficer().getName());

		
	}

	public void displayApplicationsTabular(ArrayList<Application> app) {
		for(Application a : app) {
			System.out.println(a);
		}


	}
	public void displayPendingApplications() {
		for(Application a: applications) {
			if(a.getStatus()==Status.PENDING) {
				System.out.println(a);
			}
		}

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
	            System.out.println("Top Applicant: " + maxApplicant.getName()
	                    + " (" + maxCount + " applications)");
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

	}
}
