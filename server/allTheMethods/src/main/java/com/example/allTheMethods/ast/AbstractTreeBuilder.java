package com.example.allTheMethods.ast;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

import jdk.dynalink.Operation;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.operator.Operator;
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
        ExpressionParser expressionParser = new ExpressionParser(f);
        List<Token> li = Arrays.asList(expressionParser.variable("x").build());
        Collections.reverse(li);
        it = li.iterator();
    }

    private Operation getFuntion(Token token) throws TokenizerException{
        FunctionToken t = (FunctionToken) token;
        switch (t.getFunction().getName()){
            case "acos": return new Acos(getTree());
            case "asin": return new Asin(getTree());
            case "atan": return new Atan(getTree());
            case "log": return new Log(getTree());
            case "cos": return new Cos(getTree());
            case "sin": return new Sin(getTree());
            default: throw new TokenizerException("Function error");
        }
    }
    private Operation getOperator(Token token)throws TokenizerException{
        Operation right = getTree();
        Operation left = getTree();
    }
    private Operation getTree() throws TokenizerException{
        Token t = it.next();
        switch (t.getType()){
            case Token.TOKEN_FUNCTION: return getFuntion(t);
            case Token.TOKEN_NUMBER: return new Constant(""+((NumberToken)t).getValue());
            case Token.TOKEN_OPERATOR: return getOperator(t);
            case Token.TOKEN_PARENTHESES_OPEN: return getTree();
            case Token.TOKEN_PARENTHESES_CLOSE: return getTree();
            case Token.TOKEN_VARIABLE: return new SimpleVar();
            default: throw new TokenizerException("Invalid");
        }
    }

}
