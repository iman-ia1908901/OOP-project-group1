package project;

import java.time.LocalDate;

/**
 * @author Kaltham Alemadi
 * @version Version
 * @since 2026-04-23
 */

public class StudentVisa extends Application {
	/**
     * 
     */
	private String universityName;
	/**
     * 
     */
    private int studyDuration;
	/**
     * 
     */
    private boolean scholarship;

    private static final double STUDENT_FEE = 350;
	/**
     * 
     * @param appNO
     * @param applicant
     * @param status
     * @param submissionDate
     * @param officer
     * @param universityName
     * @param studyDuration
     * @param scholarship
     */

    public StudentVisa(int appNO,Applicant applicant,Status status,LocalDate submissionDate, Officer officer,
                       String universityName, int studyDuration, boolean scholarship) {
        super(appNO, applicant,status, submissionDate, officer);
        this.universityName = universityName;
        this.studyDuration = studyDuration;
        this.scholarship = scholarship;
    }
	/**
     * 
     * @return
     */

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
	/**
     * 
     * @return
     */

    public int getStudyDuration() {
        return studyDuration;
    }
    public void setStudyDurationYears(int studyDuration) {
        this.studyDuration = studyDuration;
    }
	/**
     * 
     * @return
     */

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }
	/**
     * 
     * @return
     */

    @Override
    public double calculateProcessingFee() {
        return STUDENT_FEE + OFFICE_FEE;
    }
	/**
     * 
     * @return
     */

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Visa Type: StudentVisa\n"
                + "University Name: " + universityName + "\n"
                + "Study Duration: " + studyDuration + " years\n"
                + "Scholarship: " + (scholarship ? "YES" : "NO");
    }
}
