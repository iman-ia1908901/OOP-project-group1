package project;

import java.time.LocalDate;

/**
 * @author Kaltham Alemadi
 * @version Version
 * @since 2026-04-23
 */
public class TouristVisa extends Application {
    private int durationDays;
    private boolean hotelReservation;

    private static final double TOURIST_FEE = 500;

    public TouristVisa(int appNO,Applicant applicant, Status status,LocalDate submissionDate, Officer officer,
                       int durationDays, boolean hotelReservation) {
        super(appNO, applicant, status, submissionDate, officer);
        this.durationDays = durationDays;
        this.hotelReservation = hotelReservation;
    }
    public int getDurationDays() {
        return durationDays;
    }

    public void setDuration(int durationDays) {
        this.durationDays = durationDays;
    }

    public boolean isHotelReservation() {
        return hotelReservation;
    }

    public void setHotelReservation(boolean hotelReservation) {
        this.hotelReservation = hotelReservation;
    }

    @Override
    public double calculateProcessingFee() {
    	 return TOURIST_FEE + OFFICE_FEE;
    }
    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Visa Type: TouristVisa\n"
                + "Duration Days: " + durationDays + "\n"
                + "Hotel Reservation: " + (hotelReservation ? "YES" : "NO");
    }
}
