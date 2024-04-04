package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property;

public class PropertyReadException extends PropertyException {

    public PropertyReadException(String message) {
        super(message);
    }

    public PropertyReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
