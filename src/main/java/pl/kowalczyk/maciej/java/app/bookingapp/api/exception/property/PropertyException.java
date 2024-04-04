package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property;

import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.BookingAppException;

public class PropertyException extends BookingAppException {

    public PropertyException(String message) {
        super(message);
    }

    public PropertyException(String message, Throwable cause) {
        super(message, cause);
    }
}
