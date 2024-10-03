package test.hackathonTest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RegisteredEmailException.class)
    public ResponseEntity<String> handlerRegisteredEmailException(RegisteredEmailException e, WebRequest request) {
        String message = e.getMessage() + " " + request.getDescription(false);

        return new ResponseEntity<String>(message, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<String> EmailNotFoundException(EmailNotFoundException e, WebRequest request) {
        String message = e.getMessage() + " " + request.getDescription(false);

        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }

}
