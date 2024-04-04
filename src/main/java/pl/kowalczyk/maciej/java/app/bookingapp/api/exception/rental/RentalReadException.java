package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental;

public class RentalReadException extends RentalException {

    public RentalReadException(String message) {
        super(message);
    }

    public RentalReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
