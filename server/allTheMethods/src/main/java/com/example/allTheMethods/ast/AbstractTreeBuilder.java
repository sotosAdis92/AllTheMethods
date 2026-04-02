package com.example.allTheMethods.ast;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

import net.objecthunter.exp4j.tokenizer.*;



public class AbstractTreeBuilder {
    private String f;
    private static Iterator<Token> it = null;
    public AbstractTreeBuilder(String f){
        this.f = f;
    }
}
