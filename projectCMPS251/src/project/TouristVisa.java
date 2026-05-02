package project;

import java.time.LocalDate;

/**
 * This class represents a Tourist Visa which is a type of Application.
 * It includes duration of stay and hotel reservation status.
 * 
 * @author Kaltham Alemadi
 * @version 1.0
 * @since 2026-04-23
 */
public class TouristVisa extends Application {

    // Duration of stay in days
    private int durationDays;

    // Indicates if the applicant has a hotel reservation
    private boolean hotelReservation;

    // Constant fee for tourist visa
    private static final double TOURIST_FEE = 500;

    /**
     * Constructor to create a TouristVisa object
     * 
     * @param appNO application number
     * @param applicant applicant object
     * @param status application status
     * @param submissionDate submission date
     * @param officer assigned officer
     * @param durationDays duration in days
     * @param hotelReservation hotel reservation status
     */
    public TouristVisa(int appNO, Applicant applicant, Status status, LocalDate submissionDate, Officer officer,
                       int durationDays, boolean hotelReservation) {

        // Call parent constructor
        super(appNO, applicant, status, submissionDate, officer);

        // Initialize fields
        this.durationDays = durationDays;
        this.hotelReservation = hotelReservation;
    }

    /**
     * Returns duration of stay in days
     * @return duration in days
     */
    public int getDurationDays() {
        return durationDays;
    }

    // Sets duration of stay in days
    public void setDuration(int durationDays) {
        this.durationDays = durationDays;
    }

    /**
     * Checks if hotel reservation exists
     * @return true if reserved, false otherwise
     */
    public boolean isHotelReservation() {
        return hotelReservation;
    }

    // Sets hotel reservation status
    public void setHotelReservation(boolean hotelReservation) {
        this.hotelReservation = hotelReservation;
    }

    /**
     * Calculates processing fee for tourist visa
     * @return total fee (tourist fee + office fee)
     */
    @Override
    public double calculateProcessingFee() {
        return TOURIST_FEE + OFFICE_FEE;
    }

    /**
     * Returns string representation of tourist visa
     * @return formatted string of tourist visa details
     */
    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Visa Type: TouristVisa\n"
                + "Duration Days: " + durationDays + "\n"
                + "Hotel Reservation: " + (hotelReservation ? "YES" : "NO");
    }
}
