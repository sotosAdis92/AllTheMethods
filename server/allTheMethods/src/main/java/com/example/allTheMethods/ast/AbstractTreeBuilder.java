package com.example.allTheMethods.ast;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.tokenizer.*;
import org.springframework.expression.ExpressionParser;


public class AbstractTreeBuilder {
    private String f;
    private static Iterator<Token> it = null;

    public AbstractTreeBuilder(String f){
        this.f = f;
        init();
    }

    private void init(){
        //Expression expression = new ExpressionBuilder(f);
        //List <Token> li = Arrays.asList(expression.setVariable());
    }

}
