package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property;

public class PropertyUpdateException extends PropertyException {

    public PropertyUpdateException(String message) {
        super(message);
    }

    public PropertyUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
