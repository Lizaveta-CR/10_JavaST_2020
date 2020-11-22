package by.tsvirko.task09.service.query.exception;

public class RequestExceptionService extends Exception {
    public RequestExceptionService() {
    }

    public RequestExceptionService(String message) {
        super(message);
    }

    public RequestExceptionService(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestExceptionService(Throwable cause) {
        super(cause);
    }

    public RequestExceptionService(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
