package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property;

public class PropertyDeleteException extends PropertyException {

    public PropertyDeleteException(String message) {
        super(message);
    }

    public PropertyDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
