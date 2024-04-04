package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.address;

import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.BookingAppException;

public class AddressException extends BookingAppException {

    public AddressException(String message) {
        super(message);
    }

    public AddressException(String message, Throwable cause) {
        super(message, cause);
    }
}
