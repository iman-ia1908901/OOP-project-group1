
/**
 * @author Kaltham Alemadi
 * @version Version
 * @since 2026-04-23
 */
public class StudentVisa extends Application {
    public static final double STUDENT_FEE = 350;

    private String universityName;
    private int studyDurationYears;
    private boolean scholarship;

    public StudentVisa(int appNo, Applicant applicant, Status status, LocalDate submissionDate,
                       Officer officer, String universityName, int studyDurationYears, boolean scholarship) {
        super(appNo, applicant, status, submissionDate, officer);
        this.universityName = universityName;
        this.studyDurationYears = studyDurationYears;
        this.scholarship = scholarship;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getStudyDurationYears() {
        return studyDurationYears;
    }

    public void setStudyDurationYears(int studyDurationYears) {
        this.studyDurationYears = studyDurationYears;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public double calculateProcessingFees() {
        return STUDENT_FEE + OFFICE_FEE;
    }

    @Override
    public String getVisaType() {
        return "StudentVisa";
    }

    @Override
    public String[] getCsvExtras() {
        return new String[]{universityName, String.valueOf(studyDurationYears), String.valueOf(scholarship)};
    }
    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Visa Type: StudentVisa\n"
                + "University Name: " + universityName + "\n"
                + "Study Duration: " + studyDurationYears + " years\n"
                + "Scholarship: " + (scholarship ? "YES" : "NO");
    }
}
