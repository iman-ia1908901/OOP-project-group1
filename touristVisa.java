package project;
/**
 * @author Kaltham Alemadi
 * @version Version
 * @since 2026-04-23
 */
public class TouristVisa extends Application {
    public static final double TOURIST_FEE = 350;

    private int durationDays;
    private boolean hotelReservation;

    public TouristVisa(int appNo, Applicant applicant, Status status, LocalDate submissionDate,
                       Officer officer, int durationDays, boolean hotelReservation) {
        super(appNo, applicant, status, submissionDate, officer);
        this.durationDays = durationDays;
        this.hotelReservation = hotelReservation;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public boolean isHotelReservation() {
        return hotelReservation;
    }
    public void setHotelReservation(boolean hotelReservation) {
        this.hotelReservation = hotelReservation;
    }

    @Override
    public double calculateProcessingFees() {
        return TOURIST_FEE + OFFICE_FEE;
    }

    @Override
    public String getVisaType() {
        return "TouristVisa";
    }

    @Override
    public String[] getCsvExtras() {
        return new String[]{String.valueOf(durationDays), String.valueOf(hotelReservation)};
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Visa Type: TouristVisa\n"
                + "Duration Days: " + durationDays + "\n"
                + "Hotel Reservation: " + (hotelReservation ? "YES" : "NO");
    }
}
