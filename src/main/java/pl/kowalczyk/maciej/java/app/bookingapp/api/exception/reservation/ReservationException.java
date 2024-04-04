package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation;

import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.BookingAppException;

public class ReservationException extends BookingAppException {

    public ReservationException(String message) {
        super(message);
    }

    public ReservationException(String message, Throwable cause) {
        super(message, cause);
    }
}
