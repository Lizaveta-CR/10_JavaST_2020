package by.tsvirko.task06.dao.exception;

public class DaoStorageException extends Exception {
    public DaoStorageException() {
    }

    public DaoStorageException(String message) {
        super(message);
    }

    public DaoStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoStorageException(Throwable cause) {
        super(cause);
    }

    public DaoStorageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
