package vttp.batch5.PAF.day24_in_class.exception;

import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vttp.batch5.PAF.day24_in_class.model.exception.AccountInactiveException;
import vttp.batch5.PAF.day24_in_class.model.exception.ErrorMessage;
import vttp.batch5.PAF.day24_in_class.model.exception.InsufficientException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAccountNotFoundException(Exception ex, HttpServletRequest request,
            HttpServletResponse response) {

        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(),
                request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccountInactiveException.class)
    public ResponseEntity<ErrorMessage> handleAccountInactiveException(Exception ex, HttpServletRequest request,
            HttpServletResponse response) {

        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(),
                request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InsufficientException.class)
    public ResponseEntity<ErrorMessage> handleInsufficientBalanceException(Exception ex, HttpServletRequest request,
            HttpServletResponse response) {

        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(),
                request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
