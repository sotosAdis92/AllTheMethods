package com.example.allTheMethods.ast;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.tokenizer.*;



public class AbstractTreeBuilder {
    private String f;
    private static Iterator<Token> it = null;
    //Java Iterator Object can be used to loop through collections like ArrayList and HashMaps
    // it is called Iterator because iterating is looping through a list
    // to use it, just import it from java.util package
    // it.next() is the function to loop
    // Java Token is the smallest meaningful thing to the compiler, they consist of keywords operators constants literals etc

    public AbstractTreeBuilder(String f){
        if(f==null) throw new IllegalArgumentException("Invalid expression");
        this.f = f;
        init();
    }

    private void init(){

    }

}
