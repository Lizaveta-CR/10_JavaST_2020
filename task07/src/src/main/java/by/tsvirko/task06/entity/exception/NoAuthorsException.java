package by.tsvirko.task06.entity.exception;

public class NoAuthorsException extends Exception {
    public NoAuthorsException() {
    }

    public NoAuthorsException(String message) {
        super(message);
    }

    public NoAuthorsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAuthorsException(Throwable cause) {
        super(cause);
    }

    public NoAuthorsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
