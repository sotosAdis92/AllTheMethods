package com.example.allTheMethods.exception;

public class NullUserException extends RuntimeException{
    public NullUserException(String text){
        super(text);
    }
}
