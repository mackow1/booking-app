package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.guest;

public class GuestReadException extends GuestException {

    public GuestReadException(String message) {
        super(message);
    }

    public GuestReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
