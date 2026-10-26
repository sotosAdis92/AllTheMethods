package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.response.ErrorResponse;
import com.example.allTheMethods.exception.NullUserException;
import com.example.allTheMethods.exception.UsernameAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex){
        String errorMessage = ex.getBindingResult().getFieldErrors().stream().findFirst().map(DefaultMessageSourceResolvable::getDefaultMessage).orElse("Validation Failed");
        LocalDateTime time = LocalDateTime.now();
        log.debug("Getting error message " + errorMessage);
        log.debug("Getting time of error " + time);
        ErrorResponse errorResponse = new ErrorResponse(errorMessage,time);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
        NullUserException.class
    })
    public ResponseEntity<ErrorResponse> handleNullUserException(NullUserException ex){
        return new ResponseEntity<>(new ErrorResponse("Null User is not valid", LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
        UsernameAlreadyExistsException.class
    })
    public ResponseEntity<ErrorResponse> handleUsermameAlreadyExistsException(UsernameAlreadyExistsException ex){
        return new ResponseEntity<>(new ErrorResponse("The username provided already exists", LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
