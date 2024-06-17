package internal.api.backend.users.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class WebTokenException extends RuntimeException{

    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public WebTokenException(String message){
        super(message);
    }
}
