package com.example.allTheMethods.utils;

import com.example.allTheMethods.ast.AbstractTreeBuilder;
import com.example.allTheMethods.ast.Operation;
import com.example.allTheMethods.ast.TokenizerException;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.List;

public class MethodUtils {
    /* Implementation of the F(x) function needed for polynomial roots functions */
    public static double fx(double x, String problem){
        Expression expression = new ExpressionBuilder(problem).variables("x").build().setVariable("x",x);
        double result = expression.evaluate();
        return result;
    }
    /* Implementation of the truncate to decimal points needed for polynomial roots functions */
    public static double truncateDecimalPlaces(double x, int decimalPoint) {
        x = x * Math.pow(10, decimalPoint); //shift the decimal of the value to the given decimal 10^n
        x = Math.floor(x); //floor the number
        x = x / Math.pow(10, decimalPoint); //divide by 10^n
        //this extracts the integer part while keeping the shift
        return x;
    }
    //Function that checks if the inputs match the expected numbers based on the problem and counts how many match
    public static int CheckIfInputsMatch(List<Double> inputs, List<Double> listToCheck, int countMatching){
        for(int i=0;i<inputs.size();i++){
            if(inputs.get(i) - listToCheck.get(i) < 0.001){
                System.out.println(inputs.get(i) - listToCheck.get(i));
                countMatching++;
            }
            System.out.println(countMatching);
        }
        return countMatching;
    }
    //Funtion to check if the ammount of inputs given matches the ammount of expected inputs from the computer
    public static boolean checkExpectedListCount(int countMatching, int length, boolean flag){
        if(countMatching == length){
            flag = true;
        }
        return flag;
    }
    /* Implementation of the first derivative function needed for polynomial roots functions */
    /* This function should take in the number x and the string of the problem, although implementing an AST
    might be a better solution considering that in the future i will have to add partial derivatives
    */
    public static double fprime(double x, String problem) throws TokenizerException {
        //Implementation of the symbolic derivative, not the horner method
        //Implementation in the AST library
        //Macking a new Tree for the String to be turned into a tree
        AbstractTreeBuilder problemString = new AbstractTreeBuilder(problem);
        Operation derivative = problemString.getTree().getDerivative();
        double result = 0;
        result = derivative.getNumericResult(x);
        return result;
    }

    /*
     * Diakriti Newton Raphson fprime here, it uses the fprime approximation from the limit instead of the exact fprime
     * */
    public static double DiakritiFprime(double x,double h, String problem){
        double descreteFprime = 0.0;
        double numerator = 0.0;
        double denominator = 0.0;
        numerator = fx(x + h, problem) - fx(x,problem);
        denominator = h;
        descreteFprime = numerator / denominator;
        descreteFprime = truncateDecimalPlaces(descreteFprime,3);
        return descreteFprime;
    }
}
