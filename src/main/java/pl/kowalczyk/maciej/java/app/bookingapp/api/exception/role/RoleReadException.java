package pl.kowalczyk.maciej.java.app.bookingapp.api.exception.role;

public class RoleReadException extends RoleException {
    public RoleReadException(String message) {
        super(message);
    }

    public RoleReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
