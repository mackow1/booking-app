package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental;

public class RentalDeleteException extends RentalException {

    public RentalDeleteException(String message) {
        super(message);
    }

    public RentalDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
