package project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
            		String officerId = (s.getOfficer() == null) ? "N/A" : String.valueOf(s.getOfficer().getId());
            		writer.write("STUDENT"+","+s.getApplicationNO() + "," + s.getApplicant().getPassportNO() + "," +
                            s.getSubmissionDate()+ "," +s.getStatus()+","+ officerId+","+s.getUniversityName()+ ","+ s.getStudyDuration()+","
                            +s.isScholarship()+"\n");
            	} 
            	if(app instanceof TouristVisa) {
                	TouristVisa t = (TouristVisa)app;
                	writer.write("TOURIST"+","+t.getApplicationNO() + "," + t.getApplicant().getPassportNO() + "," +
                         t.getSubmissionDate()+ "," +t.getStatus()+","+t.getOfficer().getId()+"," +t.getDurationDays() +","+t.isHotelReservation()+","+"\n");
            	}
            	if(app instanceof WorkVisa) {
                	WorkVisa w = (WorkVisa)app;
                	writer.write("WORK"+","+w.getApplicationNO() + "," + w.getApplicant().getPassportNO() + "," +
                         w.getSubmissionDate()+ "," +w.getStatus()+","+w.getOfficer().getId()+"," +w.getCompanyName()+","+w.getSalary()+","+
                			+w.getContractYears()+"\n");
            	}
            	
            	
            }

            writer.close();
            System.out.println("Applications saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving applications.");
        }
    }
	/**
     */
    public ArrayList<Applicant> loadApplicants(){
    	ArrayList<Applicant>applicants= new ArrayList<>();
    	try {
    		 BufferedReader reader = new BufferedReader(new FileReader("applicants.csv"));
    		 String line;
    		 while((line = reader.readLine())!= null) {
    			 String[] data = line.split(",");
    			 if(data.length == 4) {
    				 String name = data[0];
    				 String passportNo = data[1];
    				 String nationality = data[2];
    				 String birthdate = data[3];
    				 applicants.add(new Applicant(name,passportNo,nationality,LocalDate.parse(birthdate)));
    			 }
    			 reader.close();
    			 System.out.println("Applicants load successfully.");
    		 }
    		 
    	}catch (IOException e) {
            System.out.println("Error loading applicants.");
    	}
    	return applicants;
    		
    }
	public ArrayList<Application> loadApplications(){
		ArrayList<Application>applications= new ArrayList<>();
    	try {
    		 BufferedReader reader = new BufferedReader(new FileReader("applications.csv"));
    		 String line;
    		 while((line = reader.readLine())!= null) {
    			 String[] data = line.split(",");
    			 if(data.length == 9) {
    				 String TypeVisa = data[0];
    				 String appNoStr = data[1];
    				 int appNo = Integer.parseInt(appNoStr);
    				 String  pasNo = data[2];
    				 String SubDate = data[3];
    				 String Status = data[4];
    				 String OfidStr = data[5];
    				 int Ofid = Integer.parseInt(OfidStr);
    				 String UniversityName = data[6];
    				 String StudyDurStr = data[7];
    				 int StudyDur = Integer.parseInt(StudyDurStr);
    				 String isScholarStr = data[8];
    				 boolean isScholar = Boolean.parseBoolean(isScholarStr);
    				 
    				 applications.add(new Application(TypeVisa,appNo,pasNo,LocalDate.parse(SubDate),Status,Ofid,UniversityName, StudyDur, isScholar));
    			 }
    			 if(data.length == 8) {
    				 String TypeVisa = data[0];
    				 String appNoStr = data[1];
    				 int appNo = Integer.parseInt(appNoStr);
    				 String  pasNo = data[2];
    				 String SubDate = data[3];
    				 String Status = data[4];
    				 String OfidStr = data[5];
    				 int Ofid = Integer.parseInt(OfidStr);
    				 String duraDaysStr = data[6];
    				 int duraDays = Integer.parseInt(duraDaysStr);
    				 String hotelReStr = data[7];
    				 boolean hotelRes= Boolean.parseBoolean(hotelReStr);
    				 
    				 applications.add(new Application(TypeVisa,appNo,pasNo,LocalDate.parse(SubDate),Status,Ofid,duraDays, hotelRes));
    			 }
    			 if(data.length == 9) {
    				 String TypeVisa = data[0];
    				 String appNoStr = data[1];
    				 int appNo = Integer.parseInt(appNoStr);
    				 String  pasNo = data[2];
    				 String SubDate = data[3];
    				 String Status = data[4];
    				 String OfidStr = data[5];
    				 int Ofid = Integer.parseInt(OfidStr);
    				 String companyName = data[6];
    				 String salaryStr= data[7];
    				 double salary = Double.parseDouble(salaryStr);
    				 String contYearStr= data[8];
    				 int contYear= Integer.parseInt(contYearStr);
    				 
    				 applications.add(new Application(TypeVisa,appNo,pasNo,LocalDate.parse(SubDate),Status,Ofid,companyName,salary,contYear));
    			 }
    			 reader.close();
    			 System.out.println("Applications load successfully.");
    		 }
    		 
    	}catch (IOException e) {
            System.out.println("Error loading applications.");
    	}
    	return applications;
    		
		
		
		
		
	}
	public ArrayList<Officer> loadOfficers(){
		ArrayList<Officer>officers= new ArrayList<>();
    	try {
    		 BufferedReader reader = new BufferedReader(new FileReader("officers.csv"));
    		 String line;
    		 while((line = reader.readLine())!= null) {
    			 String[] data = line.split(",");
    			 if(data.length == 2) {
    				 String name = data[0];
    				 String idStr = data[1];
    				 int id = Integer.parseInt(idStr);
    				 officers.add(new Officer(id, name));
    			 }
    			 reader.close();
    			 System.out.println("Officers load successfully.");
    		 }
    		 
    	}catch (IOException e) {
            System.out.println("Error loading officers.");
    	}
    	return officers;
    		
		
	}
}

