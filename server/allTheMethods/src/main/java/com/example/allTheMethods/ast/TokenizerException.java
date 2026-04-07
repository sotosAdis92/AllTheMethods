package com.example.allTheMethods.ast;

public class TokenizerException extends Exception{
    private static final long serialVersionUID = 1L;
    //Class for tokenizer exceptions to be thrown
    public TokenizerException(String message){
        super(message);
    }
}
