package project;

import java.time.LocalDate;

/**
 * This class represents a Work Visa which is a type of Application.
 * It includes company name, salary, and contract duration.
 * 
 * @author Kaltham Alemadi
 * @version 1.0
 * @since 2026-04-23
 */
public class WorkVisa extends Application {

    // Name of the company
    private String companyName;

    // Salary offered in the job
    private double salary;

    // Contract duration in years
    private int contractYears;

    // Constant fee for work visa
    private static final double WORK_FEE = 650;

    /**
     * Constructor to create a WorkVisa object
     * 
     * @param appNO application number
     * @param applicant applicant object
     * @param status application status
     * @param submissionDate submission date
     * @param officer assigned officer
     * @param companyName company name
     * @param salary salary value
     * @param contractYears contract duration in years
     */
    public WorkVisa(int appNO, Applicant applicant, Status status, LocalDate submissionDate, Officer officer,
                    String companyName, double salary, int contractYears) {

        // Call parent constructor
        super(appNO, applicant, status, submissionDate, officer);

        // Initialize fields
        this.companyName = companyName;
        this.salary = salary;
        this.contractYears = contractYears;
    }

    /**
     * Returns the company name
     * @return company name
     */
    public String getCompanyName() {
        return companyName;
    }

    // Sets the company name
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Returns the salary
     * @return salary value
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns contract duration in years
     * @return contract years
     */
    public int getContractYears() {
        return contractYears;
    }

    // Sets contract duration
    public void setContractYears(int contractYears) {
        this.contractYears = contractYears;
    }

    // Sets salary value
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Calculates processing fee for work visa
     * @return total fee (work fee + office fee)
     */
    @Override
    public double calculateProcessingFee() {
        return WORK_FEE + OFFICE_FEE;
    }

    /**
     * Returns string representation of work visa
     * @return formatted string of work visa details
     */
    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Visa Type: WorkVisa\n"
                + "Company Name: " + companyName + "\n"
                + "Salary: " + salary + "\n"
                + "Contract Years: " + contractYears + " year(s)";
    }
}
