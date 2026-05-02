package project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
* @ author: Sarah Alhajri 202403062 && Iman Alshaiba 201908901
* @ version 1.0
* @ since  2026/4/27, fixed 2026/5/1 and 2026/5/2
*/
public class  DataLoader implements DataManager {
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
            	String officerId = (app.getOfficer() == null) ? "N/A" : String.valueOf(app.getOfficer().getId());
            	if(app instanceof StudentVisa) {
            		StudentVisa s = (StudentVisa)app;
            		writer.write("STUDENT"+","+s.getApplicationNO() + "," + s.getApplicant().getPassportNO() + "," +
                            s.getSubmissionDate()+ "," +s.getStatus()+","+ officerId+","+s.getUniversityName()+ ","+ s.getStudyDuration()+","
                            +s.isScholarship()+"\n");
            	} 
            	else if(app instanceof TouristVisa) {
                	TouristVisa t = (TouristVisa)app;
                	writer.write("TOURIST"+","+t.getApplicationNO() + "," + t.getApplicant().getPassportNO() + "," +
                         t.getSubmissionDate()+ "," +t.getStatus()+","+ officerId +"," +t.getDurationDays() +","+t.isHotelReservation()+"\n");
            	}
            	else if(app instanceof WorkVisa) {
                	WorkVisa w = (WorkVisa)app;
                	writer.write("WORK"+","+w.getApplicationNO() + "," + w.getApplicant().getPassportNO() + "," +
                         w.getSubmissionDate()+ "," +w.getStatus()+","+ officerId +"," +w.getCompanyName()+","+w.getSalary()+","+
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
    			 
    		 }
    		 reader.close();
    		 System.out.println("Applicants load successfully.");
    		 
    		 
    	}catch (IOException e) {
            System.out.println("Error loading applicants.");
    	}
    	return applicants;
    		
    }
	public ArrayList<Application> loadApplications(){
		ArrayList<Application>applications= new ArrayList<>();
		ArrayList<Applicant> applicants = loadApplicants();
		 ArrayList<Officer> officers = loadOfficers();
    	try {
    		 BufferedReader reader = new BufferedReader(new FileReader("applications.csv"));
    		 reader.readLine();
    		 String line;
    		 while((line = reader.readLine())!= null) {
    			 String[] data = line.split(",");
    			 String TypeVisa = data[0];
    			 String appNoStr = data[1];
    			 int appNo = Integer.parseInt(appNoStr);
    			 String  pasNo = data[2];
    			 String SubDate = data[3];
				 Status status = Status.valueOf(data[4]);
				 String OfidStr = data[5];
			
				 
				 Applicant applicant = null;
				 for(Applicant ap : applicants) {
					 if(ap.getPassportNO().equalsIgnoreCase(pasNo)) {
						 applicant= ap;
						 break;		 
					 }
				 }
				 Officer officer = null;
				 if(!data[5].equals("N/A")) {
				int Ofid = Integer.parseInt(OfidStr);
				 for(Officer o : officers) {			 
					 if(o.getId()== Ofid) {
					  officer = o;
					   break;
					 }
				 }
			
    		 }
			
				    if(TypeVisa.equals("STUDENT")) {
    				 String UniversityName = data[6];
    				 String StudyDurStr = data[7];
    				 int StudyDur = Integer.parseInt(StudyDurStr);
    				 String isScholarStr = data[8];
    				 boolean isScholar = Boolean.parseBoolean(isScholarStr); 
    				 applications.add(new StudentVisa(appNo,applicant,status,LocalDate.parse(SubDate),officer,UniversityName, StudyDur, isScholar));
    				 
    			 }
    			 
				 else if(TypeVisa.equals("TOURIST")) {
    				 String duraDaysStr = data[6];
    				 int duraDays = Integer.parseInt(duraDaysStr);
    				 String hotelReStr = data[7];
    				 boolean hotelRes= Boolean.parseBoolean(hotelReStr);
    				 
    				 applications.add(new TouristVisa(appNo,applicant,status,LocalDate.parse(SubDate),officer,duraDays, hotelRes));
    			 }
				 else if(TypeVisa.equals("WORK")) {
   
    				 String companyName = data[6];
    				 String salaryStr= data[7];
    				 double salary = Double.parseDouble(salaryStr);
    				 String contYearStr= data[8];
    				 int contYear= Integer.parseInt(contYearStr);
    				 
    				 applications.add(new WorkVisa(appNo,applicant,status,LocalDate.parse(SubDate),officer,companyName,salary,contYear));
    			 }
    		 }
    	      System.out.println("Applications load successfully.");
    		  reader.close();
    		 
    	} catch (IOException e) {
            System.out.println("Error loading applications.");
    	}
    	return applications;		
	}
	
	
	public ArrayList<Officer> loadOfficers(){
		ArrayList<Officer>officers= new ArrayList<>();
    	try {
    		 BufferedReader reader = new BufferedReader(new FileReader("officers.csv"));
    		 reader.readLine();
    		 String line;
    		 while((line = reader.readLine())!= null) {
    			 String[] data = line.split(",");
    			 if(data.length == 2) {
    				 String idStr = data[0];
    				 String name = data[1];
    				 int id = Integer.parseInt(idStr);
    				 officers.add(new Officer(id, name));
    			 }
    		 }
    		 reader.close();
    		 System.out.println("Officers load successfully.");
    		
    		 
    	}catch (IOException e) {
            System.out.println("Error loading officers.");
    	}
    	return officers;
    		
		
	}
}

