package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.response.ErrorResponseDto;
import com.example.allTheMethods.exception.NullUserException;
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
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException ex){
        String errorMessage = ex.getBindingResult().getFieldErrors().stream().findFirst().map(DefaultMessageSourceResolvable::getDefaultMessage).orElse("Validation Failed");
        LocalDateTime time = LocalDateTime.now();
        log.debug("Getting error message " + errorMessage);
        log.debug("Getting time of error " + time);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(errorMessage,time);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
        NullUserException.class
    })
    public ResponseEntity<ErrorResponseDto> handleNullUserException(NullUserException ex){
        return new ResponseEntity<>(new ErrorResponseDto("Null User is not valid", LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
