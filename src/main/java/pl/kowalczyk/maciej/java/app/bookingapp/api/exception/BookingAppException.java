package pl.kowalczyk.maciej.java.app.bookingapp.api.exception;

public class BookingAppException extends Exception {

    public BookingAppException(String message) {
        super(message);
    }

    public BookingAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
