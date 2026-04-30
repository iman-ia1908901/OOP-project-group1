package project;

import java.time.LocalDate;

/**
 * @author Kaltham Alemadi
 * @version Version
 * @since 2026-04-23
 */
public class TouristVisa extends Application {
    private int duration;
    private boolean hotelReservation;

    private static final double TOURIST_FEE = 500;

    public TouristVisa(int appNO,Applicant applicant, Status status,LocalDate submissionDate, Officer officer,
                       int duration, boolean hotelReservation) {
        super(appNO, applicant, status, submissionDate, officer);
        this.duration = duration;
        this.hotelReservation = hotelReservation;
    }
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
                + "Duration Days: " + duration + "\n"
                + "Hotel Reservation: " + (hotelReservation ? "YES" : "NO");
    }
}
