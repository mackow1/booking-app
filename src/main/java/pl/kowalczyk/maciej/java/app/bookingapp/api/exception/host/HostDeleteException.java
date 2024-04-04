package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host;

public class HostDeleteException extends HostException {

    public HostDeleteException(String message) {
        super(message);
    }

    public HostDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
