package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental;

import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.BookingAppException;

public class RentalException extends BookingAppException {

    public RentalException(String message) {
        super(message);
    }

    public RentalException(String message, Throwable cause) {
        super(message, cause);
    }
}
