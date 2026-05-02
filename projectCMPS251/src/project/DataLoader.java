package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class loads and saves applicants, officers, and applications
 * from and to CSV files.
 *
 * @author Sarah Alhajri 202403062 && Iman Alshaiba 201908901
 * @version 1.0
 * @since 2026/4/27, fixed 2026/5/1 and 2026/5/2
 */
public class DataLoader implements DataManager {

    /**
     * Saves all applicants into applicants.csv file.
     *
     * @param applicants list of applicants to be saved
     */
    public void saveApplicants(ArrayList<Applicant> applicants) {
        try {
            // Create FileWriter to write applicants data into CSV file
            FileWriter writer = new FileWriter("applicants.csv");

            // Loop through applicants list and write each applicant information
            for (Applicant a : applicants) {
                writer.write(a.getName() + "," +
                        a.getPassportNO() + "," +
                        a.getNationality() + "," +
                        a.getBirthdate() + "\n");
            }

            // Close the file after writing
            writer.close();
            System.out.println("Applicants saved successfully.");

        } catch (IOException e) {
            // Display error message if saving fails
            System.out.println("Error saving applicants.");
        }
    }

    /**
     * Saves all officers into officers.csv file.
     *
     * @param officers list of officers to be saved
     */
    public void saveOfficers(ArrayList<Officer> officers) {
        try {
            // Create FileWriter to write officers data into CSV file
            FileWriter writer = new FileWriter("officers.csv");

            // Loop through officers list and write each officer information
            for (Officer o : officers) {
                writer.write(o.getId() + "," + o.getName() + "\n");
            }

            // Close the file after writing
            writer.close();
            System.out.println("Officers saved successfully.");

        } catch (IOException e) {
            // Display error message if saving fails
            System.out.println("Error saving officers.");
        }
    }

    /**
     * Saves all visa applications into applications.csv file.
     * The method checks the type of each application before saving it.
     *
     * @param applications list of applications to be saved
     */
    public void saveApplications(ArrayList<Application> applications) {
        try {
            // Create FileWriter to write applications data into CSV file
            FileWriter writer = new FileWriter("applications.csv");

            // Loop through all applications
            for (Application app : applications) {

                // If no officer is assigned, save officer ID as N/A
                String officerId = (app.getOfficer() == null) ? "N/A" : String.valueOf(app.getOfficer().getId());

                // Check if the application is StudentVisa
                if (app instanceof StudentVisa) {
                    StudentVisa s = (StudentVisa) app;

                    // Write student visa data in CSV format
                    writer.write("STUDENT" + "," + s.getApplicationNO() + "," + s.getApplicant().getPassportNO() + "," +
                            s.getSubmissionDate() + "," + s.getStatus() + "," + officerId + "," +
                            s.getUniversityName() + "," + s.getStudyDuration() + "," +
                            s.isScholarship() + "\n");
                }

                // Check if the application is TouristVisa
                else if (app instanceof TouristVisa) {
                    TouristVisa t = (TouristVisa) app;

                    // Write tourist visa data in CSV format
                    writer.write("TOURIST" + "," + t.getApplicationNO() + "," + t.getApplicant().getPassportNO() + "," +
                            t.getSubmissionDate() + "," + t.getStatus() + "," + officerId + "," +
                            t.getDurationDays() + "," + t.isHotelReservation() + "\n");
                }

                // Check if the application is WorkVisa
                else if (app instanceof WorkVisa) {
                    WorkVisa w = (WorkVisa) app;

                    // Write work visa data in CSV format
                    writer.write("WORK" + "," + w.getApplicationNO() + "," + w.getApplicant().getPassportNO() + "," +
                            w.getSubmissionDate() + "," + w.getStatus() + "," + officerId + "," +
                            w.getCompanyName() + "," + w.getSalary() + "," +
                            w.getContractYears() + "\n");
                }
            }

            // Close the file after writing
            writer.close();
            System.out.println("Applications saved successfully.");

        } catch (IOException e) {
            // Display error message if saving fails
            System.out.println("Error saving applications.");
        }
    }

    /**
     * Loads applicants from applicants.csv file.
     *
     * @return list of applicants loaded from the file
     */
    public ArrayList<Applicant> loadApplicants() {
        ArrayList<Applicant> applicants = new ArrayList<>();

        try {
            // Open applicants.csv file for reading
            BufferedReader reader = new BufferedReader(new FileReader("applicants.csv"));
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {

                // Split applicant data by comma
                String[] data = line.split(",");

                // Check that the line has all required applicant data
                if (data.length == 4) {
                    String name = data[0];
                    String passportNo = data[1];
                    String nationality = data[2];
                    String birthdate = data[3];

                    // Create applicant object and add it to the list
                    applicants.add(new Applicant(name, passportNo, nationality, LocalDate.parse(birthdate)));
                }
            }

            // Close the file after reading
            reader.close();
            System.out.println("Applicants load successfully.");

        } catch (IOException e) {
            // Display error message if loading fails
            System.out.println("Error loading applicants.");
        }

        return applicants;
    }

    /**
     * Loads applications from applications.csv file.
     * It also loads applicants and officers first to connect them with applications.
     *
     * @return list of applications loaded from the file
     */
    public ArrayList<Application> loadApplications() {
        ArrayList<Application> applications = new ArrayList<>();

        // Load applicants and officers to connect them with applications
        ArrayList<Applicant> applicants = loadApplicants();
        ArrayList<Officer> officers = loadOfficers();

        try {
            // Open applications.csv file for reading
            BufferedReader reader = new BufferedReader(new FileReader("applications.csv"));
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {

                // Split application data by comma
                String[] data = line.split(",");

                String TypeVisa = data[0];
                String appNoStr = data[1];
                int appNo = Integer.parseInt(appNoStr);
                String pasNo = data[2];
                String SubDate = data[3];
                Status status = Status.valueOf(data[4]);
                String OfidStr = data[5];

                // Find applicant by passport number
                Applicant applicant = null;
                for (Applicant ap : applicants) {
                    if (ap.getPassportNO().equalsIgnoreCase(pasNo)) {
                        applicant = ap;
                        break;
                    }
                }

                // Find officer by officer ID
                Officer officer = null;
                if (!data[5].equals("N/A")) {
                    int Ofid = Integer.parseInt(OfidStr);

                    for (Officer o : officers) {
                        if (o.getId() == Ofid) {
                            officer = o;
                            break;
                        }
                    }
                }

                // Create StudentVisa object if the type is STUDENT
                if (TypeVisa.equals("STUDENT")) {
                    String UniversityName = data[6];
                    String StudyDurStr = data[7];
                    int StudyDur = Integer.parseInt(StudyDurStr);
                    String isScholarStr = data[8];
                    boolean isScholar = Boolean.parseBoolean(isScholarStr);

                    applications.add(new StudentVisa(appNo, applicant, status, LocalDate.parse(SubDate), officer,
                            UniversityName, StudyDur, isScholar));
                }

                // Create TouristVisa object if the type is TOURIST
                else if (TypeVisa.equals("TOURIST")) {
                    String duraDaysStr = data[6];
                    int duraDays = Integer.parseInt(duraDaysStr);
                    String hotelReStr = data[7];
                    boolean hotelRes = Boolean.parseBoolean(hotelReStr);

                    applications.add(new TouristVisa(appNo, applicant, status, LocalDate.parse(SubDate), officer,
                            duraDays, hotelRes));
                }

                // Create WorkVisa object if the type is WORK
                else if (TypeVisa.equals("WORK")) {
                    String companyName = data[6];
                    String salaryStr = data[7];
                    double salary = Double.parseDouble(salaryStr);
                    String contYearStr = data[8];
                    int contYear = Integer.parseInt(contYearStr);

                    applications.add(new WorkVisa(appNo, applicant, status, LocalDate.parse(SubDate), officer,
                            companyName, salary, contYear));
                }
            }

            // Close the file after reading
            reader.close();
            System.out.println("Applications load successfully.");

        } catch (IOException e) {
            // Display error message if loading fails
            System.out.println("Error loading applications.");
        }

        return applications;
    }

    /**
     * Loads officers from officers.csv file.
     *
     * @return list of officers loaded from the file
     */
    public ArrayList<Officer> loadOfficers() {
        ArrayList<Officer> officers = new ArrayList<>();

        try {
            // Open officers.csv file for reading
            BufferedReader reader = new BufferedReader(new FileReader("officers.csv"));
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {

                // Split officer data by comma
                String[] data = line.split(",");

                // Check that the line has officer id and name
                if (data.length == 2) {
                    String idStr = data[0];
                    String name = data[1];
                    int id = Integer.parseInt(idStr);

                    // Create officer object and add it to the list
                    officers.add(new Officer(id, name));
                }
            }

            // Close the file after reading
            reader.close();
            System.out.println("Officers load successfully.");

        } catch (IOException e) {
            // Display error message if loading fails
            System.out.println("Error loading officers.");
        }

        return officers;
    }
}
