package project;

import java.util.ArrayList;

public interface DataManager {
	
	ArrayList<Applicant> loadApplicants();
	ArrayList<Application> loadApplications();
	ArrayList<Officer> loadOfficers();
	void saveApplicants(ArrayList<Applicant> applicants);
	void saveApplications(ArrayList<Application> applications);
	void saveOfficers(ArrayList<Officer> officers);

}
