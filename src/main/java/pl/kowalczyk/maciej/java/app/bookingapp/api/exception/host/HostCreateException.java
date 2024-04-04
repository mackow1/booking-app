package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host;

public class HostCreateException extends HostException {

    public HostCreateException(String message) {
        super(message);
    }

    public HostCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
