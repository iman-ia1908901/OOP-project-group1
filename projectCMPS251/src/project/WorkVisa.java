package project;

import java.time.LocalDate;

/**
 * @author Kaltham Alemadi
 * @version Version
 * @since 2026-04-23
 */
public class WorkVisa extends Application {
    private String companyName;
    private double salary;
    private int contractYears;

    private static final double WORK_FEE = 650;

    public WorkVisa(int appNO,Applicant applicant, Status status,LocalDate submissionDate, Officer officer,
                    String companyName, double salary, int contractYears) {
        super(appNO, applicant, status, submissionDate, officer);
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

    public int getContractYears() {
        return contractYears;
    }

    public void setContractYears(int contractYears) {
        this.contractYears = contractYears;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public double calculateProcessingFee() {
        return WORK_FEE + OFFICE_FEE;
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
