package by.tsvirko.task06.service.exception;

public class ServiceInitException extends Exception {
    public ServiceInitException() {
    }

    public ServiceInitException(String message) {
        super(message);
    }

    public ServiceInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceInitException(Throwable cause) {
        super(cause);
    }

    public ServiceInitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
