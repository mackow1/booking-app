package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host;

public class HostReadException extends HostException {

    public HostReadException(String message) {
        super(message);
    }

    public HostReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
