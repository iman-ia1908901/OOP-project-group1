package project;

import java.util.ArrayList;

public interface DataManager {
	void saveApplicants(ArrayList<Applicant> applicants);

	void saveOfficers(ArrayList<Officer> officers);

	void saveApplications(ArrayList<Application> applications);

}
