package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation;

public class ReservationCreateException extends ReservationException {

    public ReservationCreateException(String message) {
        super(message);
    }

    public ReservationCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
