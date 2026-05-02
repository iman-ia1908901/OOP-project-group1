package project;

import java.util.ArrayList;
/**
* @ author: Sarah Alhajri 202403062 && Iman Alshaiba 201908901
* @ version 
* @ since  2026/4/27 fixed 2026/5/1
*/
public interface DataManager {
	/**
	 * 
	 * @return
	 */
	ArrayList<Applicant> loadApplicants();
	ArrayList<Application> loadApplications();
	ArrayList<Officer> loadOfficers();
	void saveApplicants(ArrayList<Applicant> applicants);
	void saveApplications(ArrayList<Application> applications);
	void saveOfficers(ArrayList<Officer> officers);

}
