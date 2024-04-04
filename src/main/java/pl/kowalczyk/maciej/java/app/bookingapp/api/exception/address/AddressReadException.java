package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.address;

public class AddressReadException extends AddressException {

    public AddressReadException(String message) {
        super(message);
    }

    public AddressReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
