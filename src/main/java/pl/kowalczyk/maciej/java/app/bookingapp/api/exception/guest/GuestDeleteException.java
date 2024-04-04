package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.guest;

public class GuestDeleteException extends GuestException {

    public GuestDeleteException(String message) {
        super(message);
    }

    public GuestDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
