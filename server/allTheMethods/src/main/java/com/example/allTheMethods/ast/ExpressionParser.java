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

    //function implementation to be used in the expression
    //returns the expression builder instance
    public ExpressionParser function(Function function){
        this.userFunctions.put(function.getName(), function);
        return this;
    }

    public ExpressionParser functions(Function... functions){
        for(Function f : functions){
            this.userFunctions.put(f.getName(), f);
        }
        return this;
    }

    public ExpressionParser functions(List<Function> functions){
        for(Function f: functions){
            this.userFunctions.put(f.getName(), f);
        }
        return this;
    }

    public ExpressionParser variables(Set<String> variables){
        this.variables.addAll(variables);
        return this;
    }

    public ExpressionParser variables(String... variables){
        Collections.addAll(this.variables, variables);
        return this;
    }

    public ExpressionParser variable(String variable){
        this.variables.add(variable);
        return this;
    }
}
