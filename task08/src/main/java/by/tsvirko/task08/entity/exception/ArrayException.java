package by.tsvirko.task08.entity.exception;

public class ArrayException extends Exception {
    public ArrayException() {
    }

    public ArrayException(String message) {
        super(message);
    }

    public ArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayException(Throwable cause) {
        super(cause);
    }

    public ArrayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
