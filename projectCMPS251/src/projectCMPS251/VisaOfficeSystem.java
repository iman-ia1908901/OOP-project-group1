package projectCMPS251;

import java.util.ArrayList;
import java.util.Scanner;

public class VisaOfficeSystem {
	Scanner input = new Scanner(System.in);
	public ArrayList<Application>applications = new ArrayList<>();
	public ArrayList<Officer>officers = new ArrayList<>();;
	public ArrayList<Applicant>applicant = new ArrayList<>();;
	public int application_counter = 1000;
	public int officer_counter = 2000;
	
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
	public void removeApplication(int appNo) {
		applications.remove(appNo);
	}
	
	

}
