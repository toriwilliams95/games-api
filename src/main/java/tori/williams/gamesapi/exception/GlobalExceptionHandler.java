package tori.williams.gamesapi.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleGenericException(Exception ex) {

        logger.error("An error has occurred", ex);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


