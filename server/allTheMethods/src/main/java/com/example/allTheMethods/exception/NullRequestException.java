package com.example.allTheMethods.exception;

public class NullRequestException extends RuntimeException{
    public NullRequestException(String text){
        super(text);
    }
}
