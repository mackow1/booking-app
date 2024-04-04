package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property;

public class PropertyCreateException extends PropertyException {

    public PropertyCreateException(String message) {
        super(message);
    }

    public PropertyCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
