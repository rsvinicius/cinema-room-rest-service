package com.example.cinemaroomrestservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SeatNotAvailableException extends RuntimeException {
    public SeatNotAvailableException(String cause) {
        super(cause);
    }
}
