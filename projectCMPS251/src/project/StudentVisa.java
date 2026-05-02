package project;

import java.time.LocalDate;

/**
 * This class represents a Student Visa which is a type of Application.
 * It includes additional information such as university name,
 * study duration, and scholarship status.
 * 
 * @author Kaltham Alemadi
 * @version 1.0
 * @since 2026-04-23
 */
public class StudentVisa extends Application {

    // Name of the university
    private String universityName;

    // Duration of study in years
    private int studyDuration;

    // Indicates if the student has a scholarship
    private boolean scholarship;

    // Constant fee for student visa
    private static final double STUDENT_FEE = 350;

    /**
     * Constructor to create a StudentVisa object
     * 
     * @param appNO application number
     * @param applicant applicant object
     * @param status application status
     * @param submissionDate submission date
     * @param officer assigned officer
     * @param universityName university name
     * @param studyDuration study duration in years
     * @param scholarship scholarship status
     */
    public StudentVisa(int appNO, Applicant applicant, Status status, LocalDate submissionDate, Officer officer,
                       String universityName, int studyDuration, boolean scholarship) {

        // Call parent constructor
        super(appNO, applicant, status, submissionDate, officer);

        // Initialize fields
        this.universityName = universityName;
        this.studyDuration = studyDuration;
        this.scholarship = scholarship;
    }

    /**
     * Returns the university name
     * 
     * @return university name
     */
    public String getUniversityName() {
        return universityName;
    }

    // Sets the university name
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    /**
     * Returns study duration in years
     * 
     * @return study duration
     */
    public int getStudyDuration() {
        return studyDuration;
    }

    // Sets study duration in years
    public void setStudyDurationYears(int studyDuration) {
        this.studyDuration = studyDuration;
    }

    /**
     * Checks if the student has a scholarship
     * 
     * @return true if scholarship, false otherwise
     */
    public boolean isScholarship() {
        return scholarship;
    }

    // Sets scholarship status
    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    /**
     * Calculates processing fee for student visa
     * 
     * @return total fee (student fee + office fee)
     */
    @Override
    public double calculateProcessingFee() {
        return STUDENT_FEE + OFFICE_FEE;
    }

    /**
     * Returns string representation of student visa
     * 
     * @return formatted string of student visa details
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
