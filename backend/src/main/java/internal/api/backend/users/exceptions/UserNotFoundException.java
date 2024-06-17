package internal.api.backend.users.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserNotFoundException extends RuntimeException{

    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public UserNotFoundException(String message){
        super(message);
    }
}
