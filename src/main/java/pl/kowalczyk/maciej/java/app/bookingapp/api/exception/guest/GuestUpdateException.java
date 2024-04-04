package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.guest;

public class GuestUpdateException extends GuestException {

    public GuestUpdateException(String message) {
        super(message);
    }

    public GuestUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
