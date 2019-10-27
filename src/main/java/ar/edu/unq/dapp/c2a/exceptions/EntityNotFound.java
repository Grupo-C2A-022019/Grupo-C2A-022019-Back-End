package ar.edu.unq.dapp.c2a.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFound extends EntityNotFoundException {
    public EntityNotFound(String s) {
        super(s);
    }
}
