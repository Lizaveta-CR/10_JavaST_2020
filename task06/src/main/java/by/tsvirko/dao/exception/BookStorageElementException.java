package by.tsvirko.dao.exception;

public class BookStorageElementException extends Exception {
    public BookStorageElementException() {
    }

    public BookStorageElementException(String message) {
        super(message);
    }

    public BookStorageElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStorageElementException(Throwable cause) {
        super(cause);
    }

    public BookStorageElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
