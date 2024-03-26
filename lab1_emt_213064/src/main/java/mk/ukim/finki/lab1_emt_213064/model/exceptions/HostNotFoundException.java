package mk.ukim.finki.lab1_emt_213064.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class HostNotFoundException extends RuntimeException{
    public HostNotFoundException(Long id) {
        super(String.format("Host with id %d was not found", id));
    }
}
