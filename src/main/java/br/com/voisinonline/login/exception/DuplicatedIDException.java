package br.com.voisinonline.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DuplicatedIDException extends RuntimeException {

    private static final long serialVersionUID = 8023853541533171769L;

    public DuplicatedIDException(String message) {
        super(message);
    }
}