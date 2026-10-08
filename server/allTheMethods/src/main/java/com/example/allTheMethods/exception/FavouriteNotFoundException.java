package com.example.allTheMethods.exception;

public class FavouriteNotFoundException extends RuntimeException{
    public FavouriteNotFoundException(String message){
        super(message);
    }
}
