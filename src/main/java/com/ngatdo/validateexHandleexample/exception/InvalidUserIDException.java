package com.ngatdo.validateexHandleexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidUserIDException extends RuntimeException {
    public InvalidUserIDException(String exception) {
        super(exception);
    }
}
