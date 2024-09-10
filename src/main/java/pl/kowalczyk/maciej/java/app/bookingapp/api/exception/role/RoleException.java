package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.role;

import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.BookingAppException;

public class RoleException extends BookingAppException {
    public RoleException(String message) {
        super(message);
    }

    public RoleException(String message, Throwable cause) {
        super(message, cause);
    }
}
