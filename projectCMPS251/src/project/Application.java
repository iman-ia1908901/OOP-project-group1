package project;

/**
 * @author: Iman Alshaiba 
 * @ version: 1.0
 * @ since 18-4-2026
 */

import java.time.LocalDate;
/**
 * This class represents abstract class Application in the system, consisting of applicationNO,
 * submissionDate, applicant, status, officer and officer fee information.
 */
public abstract class Application {
	/**
	* This is the application No for the Application
	*/
	private int applicationNO;
	/**
	* This is the submission date for the Application
	*/
	private LocalDate submissionDate;
	/**
	*This is the applicant for the Application (composition)
	*/
	private Applicant applicant;
	/**
	* This is status enum for the Application
	*/
	private Status status;
	/**
	*This is the officer for the Application (composition)
	*/
	private Officer officer;
	/**
	*This is the office fee for the Application 
	*/
	public static final double OFFICE_FEE = 250;

	/**
	 * 
	 * 
	 * Constructors
	 * @param appNO
	 * @param applicant
	 * @param status
	 * @param submissionDate
	 * @param officer
	 * 
	 * creates constructor an Application parameters
	 */
	
	public Application(int appNO,Applicant applicant,Status status,LocalDate submissionDate, Officer officer) {
		super();
		this.applicationNO = appNO;
		this.submissionDate = submissionDate;
		this.applicant = applicant;
		this.status = status;
		this.officer = officer;
	}
	/**
	 * 
	 * @return
	 * return Application application No
	 */

	public int getApplicationNO() {
		return applicationNO;
	}


	/**
	 * @param applicationNO
	 * sets application No  for Application 
	 */
	public void setApplicationNO(int applicationNO) {
		this.applicationNO = applicationNO;
	}
	/**
	 * 
	 * @return
	 * return submissionDate for Application 
	 */

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}


	/**
	 * @param submissionDate
	 * set submissionDate for Application 
	 */
	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}
	/**
	 * 
	 * @return
	 * return applicant for Application 
	 * 
	 */

	public Applicant getApplicant() {
		return applicant;
	}


	/**
	 * @param applicant
	 * sets applicant for Application 
	 */
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	/**
	 * 
	 * @return
	 * return status for Application 
	 */
	
	public Status getStatus() {
		return status;
	}


	/**
	 * @param status
	 * sets status for Application 
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * 
	 * @return
	 * return Officer of Application 
	 */

	public Officer getOfficer() {
		return officer;
	}


	/**
	 * @param officer
	 * sets Officer of Application
	 */
	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	/**
	* sets status APPROVED of Application 
	*/

	public void approveApplication() {
		this.status=Status.APPROVED;

	}
	/**
	*sets status REJECTE of Application 
	*/

	public void rejectApplication() {
		this.status=Status.REJECTED;

	}
	/**
	*
	*
	*/
	/**
	 * @return
	 * return the calculate processing fee of Application 
	 */
	public  double calculateProcessingFee() {
		return OFFICE_FEE;	

	}
	/**
	 * 
	 * @return
	 * return String representation of Application
	 */
	@Override
	public String toString() {
		return "Application [applicationNO=" + applicationNO + ", submissionDate=" + submissionDate + ", applicant="
				+ applicant + ", status=" + status + ", officer=" + officer + "]";
	}

	







}
