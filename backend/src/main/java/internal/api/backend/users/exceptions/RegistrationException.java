package internal.api.backend.users.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RegistrationException extends RuntimeException{

    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public RegistrationException(String message){
        super(message);
    }
}
