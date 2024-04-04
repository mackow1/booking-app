package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.address;

public class AddressUpdateException extends AddressException {

    public AddressUpdateException(String message) {
        super(message);
    }

    public AddressUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
