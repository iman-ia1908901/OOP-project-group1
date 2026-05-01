package project;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader implements DataManager {
	
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

    public void saveApplications(ArrayList<Application> applications) {
        try {
            FileWriter writer = new FileWriter("applications.csv");

            for (Application app : applications) {
            	if(app instanceof StudentVisa) {
            		StudentVisa s = (StudentVisa)app;
            		add.writer(s.getUniversityName());
            		s.getUniversityName();
            		
            		s.getStudyDuration();
            		s.isScholarship();
                 writer.write(app.getApplicationNO() + "," + app.getApplicant().getPassportNO() + "," +
                 app.getSubmissionDate()+ "," +app.getStatus() +app.getOfficer().getId()+app.ge+"\n");		
            	}
            }

            writer.close();
            System.out.println("Applications saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving applications.");
        }
    }
    ArrayList<Applicant> loadApplicants();
	ArrayList<Application> loadApplications();
	ArrayList<Officer> loadOfficers();
}

