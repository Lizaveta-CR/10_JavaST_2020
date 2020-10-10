package main.java.by.tsvirko.service.exception;

public class FileOpeningException extends Exception {
    public FileOpeningException() {
    }

    public FileOpeningException(String message) {
        super(message);
    }

    public FileOpeningException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileOpeningException(Throwable cause) {
        super(cause);
    }
}
