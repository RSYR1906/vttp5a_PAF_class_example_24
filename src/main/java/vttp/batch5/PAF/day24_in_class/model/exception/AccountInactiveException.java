package vttp.batch5.PAF.day24_in_class.model.exception;

public class AccountInactiveException extends RuntimeException {

    public AccountInactiveException() {
    }

    public AccountInactiveException(String message) {
        super(message);
    }

    public AccountInactiveException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
