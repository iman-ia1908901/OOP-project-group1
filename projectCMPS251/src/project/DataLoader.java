package project;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader implements DataManager {
	
	public void saveApplicants(ArrayList<Applicant> applicants) {
        try {
            FileWriter writer = new FileWriter("applicants.txt");

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
            FileWriter writer = new FileWriter("officers.txt");

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
            FileWriter writer = new FileWriter("applications.txt");

            for (Application app : applications) {
                writer.write(app.getApplicationNO() + "," +
                        app.getApplicant().getName() + "," +
                        app.getStatus() + "," +
                        app.getSubmissionDate() + "\n");
            }

            writer.close();
            System.out.println("Applications saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving applications.");
        }
    }
}

