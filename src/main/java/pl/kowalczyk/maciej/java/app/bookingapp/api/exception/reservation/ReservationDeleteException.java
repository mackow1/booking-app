package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation;

public class ReservationDeleteException extends ReservationException {

    public ReservationDeleteException(String message) {
        super(message);
    }

    public ReservationDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
