package com.example.cinemaroomrestservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongTokenException extends RuntimeException {
    public WrongTokenException(String cause) {
        super(cause);
    }

    public WrongTokenException() {
    }
}
