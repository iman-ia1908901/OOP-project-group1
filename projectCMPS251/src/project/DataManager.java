package project;

import java.util.ArrayList;
/**
* @ author: Sarah Alhajri 202403062
* @ version 
* @ since : 
*/
public interface DataManager {
	
	ArrayList<Applicant> loadApplicants();
	ArrayList<Application> loadApplications();
	ArrayList<Officer> loadOfficers();
	void saveApplicants(ArrayList<Applicant> applicants);
	void saveApplications(ArrayList<Application> applications);
	void saveOfficers(ArrayList<Officer> officers);

}
