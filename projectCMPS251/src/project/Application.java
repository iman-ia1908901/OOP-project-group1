package project;

/* 
 * @author: Iman Alshaiba 
 * @ version: 
 * @ since 18-4-2026
 */

import java.time.LocalDate;

public class Application {
	private int applicationNO;
	private LocalDate submissionDate;
	private Applicant applicant;
	private Status status;
	private Officer officer;
	public double OFFICE_FEE = 250;
	
	public Application(int applicationNO, LocalDate submissionDate, Applicant applicant, Status status,
			Officer officer) {
		super();
		this.applicationNO = applicationNO;
		this.submissionDate = submissionDate;
		this.applicant = applicant;
		this.status = status;
		this.officer = officer;
	}
	
	
	public int getApplicationNO() {
		return applicationNO;
	}


	public void setApplicationNO(int applicationNO) {
		this.applicationNO = applicationNO;
	}


	public LocalDate getSubmissionDate() {
		return submissionDate;
	}


	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}


	public Applicant getApplicant() {
		return applicant;
	}


	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Officer getOfficer() {
		return officer;
	}


	public void setOfficer(Officer officer) {
		this.officer = officer;
	}


	public void approveApplication() {
		
	}
	
	public void rejectApplication() {
		
	}
	public double calculateProccessingFee() {
		
	}
	public String toString() {
		
		
	}
	
	
	


	

}
