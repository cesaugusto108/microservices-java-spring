package ces.augusto108.hruser.model.services.exceptions;

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUID = 6767350389858037419L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
