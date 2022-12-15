package ces.augusto108.hremployee.model.controllers.handlers;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 4151984600155879827L;

    private final Integer httpResponseStatus;
    private final String message;
    private final Long timestamp;
    private final String httpMethod;

    public StandardError(Integer httpResponseStatus, String message, Long timestamp, String httpMethod) {
        this.httpResponseStatus = httpResponseStatus;
        this.message = message;
        this.timestamp = timestamp;
        this.httpMethod = httpMethod;
    }

    public Integer getHttpResponseStatus() {
        return httpResponseStatus;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getHttpMethod() {
        return httpMethod;
    }
}
