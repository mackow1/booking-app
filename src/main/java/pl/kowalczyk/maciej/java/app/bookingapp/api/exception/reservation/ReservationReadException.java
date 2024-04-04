package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation;

public class ReservationReadException extends ReservationException {

    public ReservationReadException(String message) {
        super(message);
    }

    public ReservationReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
