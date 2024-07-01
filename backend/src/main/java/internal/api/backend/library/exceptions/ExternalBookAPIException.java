package internal.api.backend.library.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExternalBookAPIException extends RuntimeException{

    private final HttpStatus status;
    private final String url;

    public ExternalBookAPIException(String message, HttpStatus status, String url){
        super(message);
        this.status = status;
        this.url = url;
    }

    @Override
    public String getMessage(){
        return "Error from " + url + ": " + getMessage();
    }
}
