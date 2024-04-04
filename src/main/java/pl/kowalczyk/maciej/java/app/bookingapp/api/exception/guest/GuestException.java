package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.guest;

import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.BookingAppException;

public class GuestException extends BookingAppException {

    public GuestException(String message) {
        super(message);
    }

    public GuestException(String message, Throwable cause) {
        super(message, cause);
    }
}
