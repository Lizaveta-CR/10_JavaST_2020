package by.tsvirko.task09.service.interpreter.exception;

public class NoExpressionException extends Exception {
    public NoExpressionException() {
    }

    public NoExpressionException(String message) {
        super(message);
    }

    public NoExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoExpressionException(Throwable cause) {
        super(cause);
    }

    public NoExpressionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
