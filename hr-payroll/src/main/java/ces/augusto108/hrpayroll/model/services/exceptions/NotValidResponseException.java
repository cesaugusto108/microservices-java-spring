package ces.augusto108.hrpayroll.model.services.exceptions;

public class NotValidResponseException extends RuntimeException{
    private static final long serialVersionUID = 5838673702832994603L;

    public NotValidResponseException(String message) {
        super(message);
    }

    public NotValidResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
