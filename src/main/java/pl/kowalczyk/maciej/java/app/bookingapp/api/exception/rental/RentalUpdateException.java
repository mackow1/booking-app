package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental;

public class RentalUpdateException extends RentalException {

    public RentalUpdateException(String message) {
        super(message);
    }

    public RentalUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
