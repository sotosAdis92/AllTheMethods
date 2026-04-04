package com.example.allTheMethods.ast;
import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.operator.Operator;

import java.util.*;

/*Factory class for Expression instances. This class is the main entry point of the API. create new instances of this class*/
public class ExpressionParser {
    private String expression;
    private Map<String, Function> userFunctions;
    private Map<String, Operator> userOperators;
    private Set<String> variables;
    private boolean implicitMultiplication = true;

    public ExpressionParser(String expression) {
        if(expression == null || expression.trim().length() == 0){
            throw new IllegalArgumentException("Expression cannot be null");
        }
        this.expression = expression;
        this.userOperators = new HashMap<String, Operator>(4);
        this.userFunctions = new HashMap<String, Function>(4);
        this.variables = new HashSet<String>(4);
    }
}
