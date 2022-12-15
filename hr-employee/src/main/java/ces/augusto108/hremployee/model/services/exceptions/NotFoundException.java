package ces.augusto108.hremployee.model.services.exceptions;

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUID = -6462502576828218686L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
