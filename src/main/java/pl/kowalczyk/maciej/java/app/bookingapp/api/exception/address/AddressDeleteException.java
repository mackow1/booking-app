package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.address;

public class AddressDeleteException extends AddressException {

    public AddressDeleteException(String message) {
        super(message);
    }

    public AddressDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
