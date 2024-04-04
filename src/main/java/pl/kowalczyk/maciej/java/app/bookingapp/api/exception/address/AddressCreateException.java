package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.address;

public class AddressCreateException extends AddressException {

    public AddressCreateException(String message) {
        super(message);
    }

    public AddressCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
