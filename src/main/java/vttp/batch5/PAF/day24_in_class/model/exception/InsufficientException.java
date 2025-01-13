package vttp.batch5.PAF.day24_in_class.model.exception;

public class InsufficientException extends RuntimeException {

    public InsufficientException() {
    }

    public InsufficientException(String message) {
        super(message);
    }

    public InsufficientException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
