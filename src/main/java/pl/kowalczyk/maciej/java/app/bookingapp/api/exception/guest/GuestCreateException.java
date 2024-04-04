package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.guest;

public class GuestCreateException extends GuestException {

    public GuestCreateException(String message) {
        super(message);
    }

    public GuestCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
