package ces.augusto108.hrpayroll.model.controllers.handlers;

import ces.augusto108.hrpayroll.model.services.exceptions.NotValidResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NotValidResponseException.class)
    public ResponseEntity<StandardError> handleNotFoundException(
            NotValidResponseException e,
            HttpServletRequest httpServletRequest
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new StandardError(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage(),
                        System.currentTimeMillis(),
                        httpServletRequest.getMethod()
                )
        );
    }
}
