package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental;

public class RentalCreateException extends RentalException {

    public RentalCreateException(String message) {
        super(message);
    }

    public RentalCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
