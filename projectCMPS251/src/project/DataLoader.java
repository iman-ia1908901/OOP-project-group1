package project;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
* @ author: Sarah Alhajri 202403062
* @ version 
* @ since  
*/
public class DataLoader implements DataManager {
	/**
	 * 
	 * @param applicants
	 */
	public void saveApplicants(ArrayList<Applicant> applicants) {
        try {
            FileWriter writer = new FileWriter("applicants.csv");

            for (Applicant a : applicants) {
                writer.write(a.getName() + "," +
                        a.getPassportNO() + "," +
                        a.getNationality() + "," +
                        a.getBirthdate() + "\n");
            }

            writer.close();
            System.out.println("Applicants saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving applicants.");
        }
    }
	/**
	 * 
	 * @param officers
	 */

    public void saveOfficers(ArrayList<Officer> officers) {
        try {
            FileWriter writer = new FileWriter("officers.csv");

            for (Officer o : officers) {
                writer.write(o.getId() + "," + o.getName() + "\n");
            }

            writer.close();
            System.out.println("Officers saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving officers.");
        }
    }
	/**
     * 
     * @param applications
     */


    public void saveApplications(ArrayList<Application> applications) {
        try {
            FileWriter writer = new FileWriter("applications.csv");

            for (Application app : applications) {
            	if(app instanceof StudentVisa) {
            		StudentVisa s = (StudentVisa)app;
            		int officerId = (s.getOfficer() == null) ? "N/A" : s.getOfficer().getId();
            		writer.write("STUDENT"+","+s.getApplicationNO() + "," + s.getApplicant().getPassportNO() + "," +
                            s.getSubmissionDate()+ "," +s.getStatus()+","+ officerId+","+s.getUniversityName()+ ","+ s.getStudyDuration()+","
                            +s.isScholarship()+"\n");
            		 
            	
            	}
            }

            writer.close();
            System.out.println("Applications saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving applications.");
        }
    }
	/**
     * 
     * @return
     */
    ArrayList<Applicant> loadApplicants();
	ArrayList<Application> loadApplications();
	ArrayList<Officer> loadOfficers();
}

