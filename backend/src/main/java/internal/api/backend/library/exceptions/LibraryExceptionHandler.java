package internal.api.backend.library.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LibraryExceptionHandler {

    @ExceptionHandler(ExternalBookAPIException.class)
    public ResponseEntity<String> externalBookAPIException(ExternalBookAPIException ex){
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }
}
