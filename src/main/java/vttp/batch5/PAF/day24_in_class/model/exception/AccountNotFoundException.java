package vttp.batch5.PAF.day24_in_class.model.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
