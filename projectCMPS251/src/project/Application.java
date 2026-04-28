package project;

/* 
 * @author: Iman Alshaiba 
 * @ version: 
 * @ since 18-4-2026
 */

import java.time.LocalDate;

public abstract class Application {
	private int applicationNO;
	private LocalDate submissionDate;
	private Applicant applicant;
	private Status status;
	private Officer officer;
	public double OFFICE_FEE = 250;

	public Application(int appNO,Applicant applicant, Status status,LocalDate submissionDate, Officer officer) {
		super();
		this.applicationNO = appNO;
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
	public abstract double calculateProccessingFee() {
		return OFFICE_FEE;	

	}


	@Override
	public String toString() {
		return "Application [applicationNO=" + applicationNO + ", submissionDate=" + submissionDate + ", applicant="
				+ applicant + ", status=" + status + ", officer=" + officer + ", OFFICE_FEE=" + OFFICE_FEE
				+ ", getApplicationNO()=" + getApplicationNO() + ", getSubmissionDate()=" + getSubmissionDate()
				+ ", getApplicant()=" + getApplicant() + ", getStatus()=" + getStatus() + ", getOfficer()="
				+ getOfficer() + ", calculateProccessingFee()=" + calculateProccessingFee() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	







}