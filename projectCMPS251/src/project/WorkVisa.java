package project;

import java.time.LocalDate;

/**
 * @author Kaltham Alemadi
 * @version Version
 * @since 2026-04-23
 */
public class WorkVisa extends Application {
    public static final double WORK_FEE = 350;

    private String companyName;
    private double salary;
    private int contractYears;

    public WorkVisa(int appNo, Applicant applicant, Status status, LocalDate submissionDate,
                    Officer officer, String companyName, double salary, int contractYears) {
        super(appNo, applicant, status, submissionDate, officer);
        this.companyName = companyName;
        this.salary = salary;
        this.contractYears = contractYears;
    }

    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getContractYears() {
        return contractYears;
    }

    public void setContractYears(int contractYears) {
        this.contractYears = contractYears;
    }

    @Override
    public double calculateProcessingFees() {
        return WORK_FEE + OFFICE_FEE;
    }

    @Override
    public String getVisaType() {
        return "WorkVisa";
    }

    @Override
    public String[] getCsvExtras() {
        return new String[]{companyName, String.valueOf(salary), String.valueOf(contractYears)};
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Visa Type: WorkVisa\n"
                + "Company Name: " + companyName + "\n"
                + "Salary: " + salary + "\n"
                + "Contract Years: " + contractYears + " year(s)";
    }
}
