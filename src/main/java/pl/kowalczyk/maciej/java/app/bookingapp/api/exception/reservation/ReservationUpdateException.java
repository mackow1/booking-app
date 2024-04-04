package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation;

public class ReservationUpdateException extends ReservationException {

    public ReservationUpdateException(String message) {
        super(message);
    }

    public ReservationUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
