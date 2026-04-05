package com.example.allTheMethods.ast;
import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.function.Functions;
import net.objecthunter.exp4j.operator.Operator;
import net.objecthunter.exp4j.shuntingyard.ShuntingYard;
import net.objecthunter.exp4j.tokenizer.Token;

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
        this.expression = expression; //The expression as a String is stored in here
        this.userOperators = new HashMap<String, Operator>(4); //Store the Operators of the expression in a HashMap of operator as a String and Operator variable
        this.userFunctions = new HashMap<String, Function>(4); //Store the functions of the expression in a HashMap of function as a String and Function variable
        this.variables = new HashSet<String>(4); //Variables stored in here
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

    public ExpressionParser implicitMultiplication(boolean enabled){
        this.implicitMultiplication = enabled;
        return this;
    }

    public ExpressionParser operator(Operator operator){
        this.checkSymbolOperator(operator);
        this.userOperators.put(operator.getSymbol(), operator);
        return this;
    }
    public void checkSymbolOperator(Operator operator){
        String name = operator.getSymbol();
        for(char c: name.toCharArray()){
            if(!Operator.isAllowedOperatorChar(c)){
                throw new IllegalArgumentException("The operator symbol is invalid");
            }
        }
    }
    public ExpressionParser operator(Operator... operators){
        for(Operator o : operators){
            this.operator(o);
        }
        return this;
    }
    public ExpressionParser operators(List<Operator> operators){
        for(Operator o : operators){
            this.operator(o);
        }
        return this;
    }

    public Token[] build(){
        if(expression.length() ==0){
            throw new IllegalArgumentException("The expression cannot be empty");
        }
        variables.add("pi");
        variables.add("π");
        variables.add("e");
        variables.add("φ");

        for(String var : variables){
            if(Functions.getBuiltinFunction(var) != null || userFunctions.containsKey(var)){
                throw new IllegalArgumentException("A variable can not have the same name as a function");
            }
        }
        Token[] a = ShuntingYard.convertToRPN(this.expression, this.userFunctions, this.userOperators, this.variables, this.implicitMultiplication);
        return a;
    }

}
