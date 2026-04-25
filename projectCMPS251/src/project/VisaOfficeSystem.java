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
	public ArrayList<Officer>officers = new ArrayList<>();;
	public ArrayList<Applicant>applicants = new ArrayList<>();;
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
			if(ap.getPassportNO()== passportNo) {
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
		
	}
	public void displayAssignedApplications(int officerID) {
		for(Application a: applications) {
			if(a.getOfficer().getId()== officerID) {
				System.out.println(a);
			}
		}
		
	}
	
	public void displayApplicationTabular(Application a) {
		
		
	}
	
	public void displayApplicationsTabular(ArrayList<Application> app) {
		for(Application app : applications) {
			System.out.println(app);
		}
		
		
	}
	public void displayPendingApplications() {
		
	}
	
	public void calculateWithMostApplications() {
		
	}

	public void displayApplicationsBeforeDate( LocalDate date) {
		
	}
	public void save() {
		
	}
}
