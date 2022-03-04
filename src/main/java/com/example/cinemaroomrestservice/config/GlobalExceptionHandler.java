package com.example.cinemaroomrestservice.config;

import com.example.cinemaroomrestservice.exception.NotFoundException;
import com.example.cinemaroomrestservice.exception.SeatNotAvailableException;
import com.example.cinemaroomrestservice.exception.WrongPasswordException;
import com.example.cinemaroomrestservice.exception.WrongTokenException;
import com.example.cinemaroomrestservice.model.error.BaseExceptionBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String PURCHASE_PATH = "/purchase";
    public static final String RETURN_PATH = "/return";
    public static final String STATS_PATH = "/stats";


    @ExceptionHandler
    ResponseEntity<BaseExceptionBody> handleNotFoundException(NotFoundException exception) {
        BaseExceptionBody baseExceptionBody = new BaseExceptionBody(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                PURCHASE_PATH
        );
        return new ResponseEntity<>(baseExceptionBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<BaseExceptionBody> handleSeatNotAvailableException(SeatNotAvailableException exception) {
        BaseExceptionBody baseExceptionBody = new BaseExceptionBody(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                PURCHASE_PATH
        );
        return new ResponseEntity<>(baseExceptionBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<BaseExceptionBody> handleWrongTokenException(WrongTokenException exception) {
        BaseExceptionBody baseExceptionBody = new BaseExceptionBody(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                RETURN_PATH
        );
        return new ResponseEntity<>(baseExceptionBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<BaseExceptionBody> handleWrongPasswordException(WrongPasswordException exception) {
        BaseExceptionBody baseExceptionBody = new BaseExceptionBody(
                HttpStatus.UNAUTHORIZED.value(),
                exception.getMessage(),
                STATS_PATH
        );
        return new ResponseEntity<>(baseExceptionBody, HttpStatus.UNAUTHORIZED);
    }
}
