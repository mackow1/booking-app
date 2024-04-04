package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host;

import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.BookingAppException;

public class HostException extends BookingAppException {

    public HostException(String message) {
        super(message);
    }

    public HostException(String message, Throwable cause) {
        super(message, cause);
    }
}
