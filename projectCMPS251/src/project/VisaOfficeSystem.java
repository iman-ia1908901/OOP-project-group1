package project;
/* 
 * @author: Iman Alshaiba 
 * @ version: 
 * @ since 23-4-2026
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class VisaOfficeSystem {
	Scanner in = new Scanner(System.in);
	public ArrayList<Application>applications = new ArrayList<>();
	public ArrayList<Officer>officers = new ArrayList<>();;
	public ArrayList<Applicant>applicant = new ArrayList<>();;
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
		applicant.add(app);
	}
	
	public void displayAllOfficers() {
		
	}
	public void assignOfficerToApplication(Application app, Officer officer) {
		
		
	}
	public Application findApplicationByApplicationNo(int appNo) {
		
	}
	public Officer findOfficerByID(int officerId) {
		
		
	}
	public Applicant findApplicantByPassportNo(String passportNo) {
		
	}
	public void viewAllApplicantions() {
		
	}
	
	public void removeApplication(int appNo) {
		applications.remove(appNo);
	}
	
	public void processApplication(Application app, Status status) {
		
	}
	public void displayAssignedApplications(int officerID) {
		
	}
	
	public void displayApplicationTabular(Application a) {
		
	}
	
	public void displayApplicationsTabular(ArrayList<Application> app) {
		
		
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
