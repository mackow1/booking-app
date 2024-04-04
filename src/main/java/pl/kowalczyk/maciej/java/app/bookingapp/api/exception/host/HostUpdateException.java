package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host;

public class HostUpdateException extends HostException {

    public HostUpdateException(String message) {
        super(message);
    }

    public HostUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
