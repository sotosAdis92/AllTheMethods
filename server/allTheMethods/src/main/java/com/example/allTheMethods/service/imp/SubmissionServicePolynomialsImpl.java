package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.ast.AbstractTreeBuilder;
import com.example.allTheMethods.ast.Operation;
import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.service.SubmissionServicePolynomials;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.example.allTheMethods.utils.MethodUtils.*;

@AllArgsConstructor
@Service
public class SubmissionServicePolynomialsImpl implements SubmissionServicePolynomials {
    /*
    Method Implementation of Bisection Method, the method takes in a bisectionData object
    and through the bisection method creates its own list of outputs, and compares that list
    with the list of inputs from the user, if the list matches within 3 significant digits of
    the correct answer, for all the numbers entered by the client, then it returns true.
     */
    @Override
    public boolean checkDataBisection(BisectionDataDto bisectionDataDto) {
        //Starting Values
        boolean flag = false;
        int i=0;
        int countMatchingInputs = 0;
        int decimalPoint = 3;
        List<Double> input = bisectionDataDto.getInp();
        int length = bisectionDataDto.getIterations();
        int Inta = bisectionDataDto.getProblemSpaceA();
        int Intb = bisectionDataDto.getProblemSpaceB();
        String problem = bisectionDataDto.getProblemString();
        List<Double> listToCheck = new ArrayList<>();
        double DomainA = (int)Inta;
        double DomainB = (int)Intb;
        double x = 0;
        double resultX = 0;
        double resultA = 0;
        //Until Here

        for(i=0;i<length;i++){
            x = (DomainA+DomainB)/2;
            resultX = fx(x, problem);
            resultA = fx(DomainA, problem);

            if(resultX * resultA < 0){
                DomainB = x;
            }
            else{
                DomainA = x;
            }

            x = truncateDecimalPlaces(x,decimalPoint); //Turn x into a 3 decimal max double function
            listToCheck.add(x); //add it to the list to check
        }

        countMatchingInputs = CheckIfInputsMatch(input,listToCheck,countMatchingInputs); //Function that checks if the inputs given are the expected ones
        flag = checkExpectedListCount(countMatchingInputs, length, flag); //Function that checks if count is the same as length (valid inputs)
        return flag;
    }

    /*
    Method Implementation of Regula-Falsi Method, the method takes in a regulaFalsiData object
    and through the Regula-Falsi Method creates its own list of outputs, and compares that list
    with the list of inputs from the user, if the list matches within 3 significant digits of
    the correct answer, for all the numbers entered by the client, then it returns true.
     */
    @Override
    public boolean checkDataRegulaFalsi(RegulaFalsiDataDto regulaFalsiDataDto) {
        boolean flag  = false;
        int i = 0;
        int countMatchingInputs = 0;
        int decimalPoint = 3;

        List<Double> input = regulaFalsiDataDto.getInp();
        int length = regulaFalsiDataDto.getIterations();
        int Inta = regulaFalsiDataDto.getProblemSpaceA();
        int Intb = regulaFalsiDataDto.getProblemSpaceB();
        String problem = regulaFalsiDataDto.getProblemString();

        List<Double> listToCheck = new ArrayList<>();
        double x = 0;
        double a = Inta;
        double b = Intb;
        double resultX = 0;
        double resultA = 0;

        for(i=0;i<length;i++){
            x = b - ( fx(b,problem) * (b - a) / (fx(b,problem) - fx(a, problem) ));
            resultX = fx(x, problem);
            resultA = fx(a, problem);
            if(resultX * resultA < 0){
                b = x;
            }
            else{
                a = x;
            }
            x = truncateDecimalPlaces(x,decimalPoint);
            listToCheck.add(x);
            System.out.println(x);
            System.out.println(input);
        }


        countMatchingInputs = CheckIfInputsMatch(input,listToCheck,countMatchingInputs); //Function that checks if the inputs given are the expected ones
        flag = checkExpectedListCount(countMatchingInputs, length, flag); //Function that checks if count is the same as length (valid inputs)

        return flag;
    }

    /*
    Method Implementation of Newton-Raphson Method, the method takes in a newtonRaphson object
    and through the Newton-Raphson Method creates its own list of outputs, and compares that list
    with the list of inputs from the user, if the list matches within 3 significant digits of
    the correct answer, for all the numbers entered by the client, then it returns true.
     */
    @Override
    public boolean checkDataNewtonRaphson(NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException {
        boolean flag = false;
        int i = 0;
        int countMatchingInputs = 0;
        int decimalPoint = 3;
        double xk = newtonRaphsonDataDto.getXo();
        List<Double> input = newtonRaphsonDataDto.getInp();
        String problem = newtonRaphsonDataDto.getProblemString();
        int iterations = newtonRaphsonDataDto.getIterations();

        double x = 0;
        List<Double> listToCheck = new ArrayList<>();

        for(i=0;i<iterations;i++){
            x = xk - (fx(xk,problem)/fprime(xk,problem));
            x = truncateDecimalPlaces(x, decimalPoint);
            System.out.println(x);
            listToCheck.add(x);
            xk = x;
        }
        countMatchingInputs = CheckIfInputsMatch(input,listToCheck,countMatchingInputs); //Function that checks if the inputs given are the expected ones
        flag = checkExpectedListCount(countMatchingInputs, iterations, flag); //Function that checks if count is the same as length (valid inputs)
        return flag;
    }

    /*
    Method Implementation of Discrete Newton-Raphson Method, the method takes in a DiakritinewtonRaphson object
    and through the Discrete Newton-Raphson Method creates its own list of outputs, and compares that list
    with the list of inputs from the user, if the list matches within 3 significant digits of
    the correct answer, for all the numbers entered by the client, then it returns true.
     */
    @Override
    public boolean checkDataDiakritiNewtonRaphson(DiakritiNewtonRaphsonDto diakritiNewtonRaphsonDto) {
        boolean flag = false;
        int i = 0;
        int countMatchingInputs = 0;
        int decimalPoint = 3;
        double xk = diakritiNewtonRaphsonDto.getXoParameter();
        int hParameter = diakritiNewtonRaphsonDto.gethParameter();
        List<Double> input = diakritiNewtonRaphsonDto.getInp();
        String problemString = diakritiNewtonRaphsonDto.getProblemString();
        int iterations = diakritiNewtonRaphsonDto.getIterations();
        double x = 0;
        List<Double> listToCheck = new ArrayList<>();

        for(i=0;i<iterations;i++){
            x = xk - (fx(xk,problemString) / DiakritiFprime(xk,hParameter,problemString));
            x = truncateDecimalPlaces(x, decimalPoint);
            listToCheck.add(x);
            xk = x;
        }
        countMatchingInputs = CheckIfInputsMatch(input,listToCheck,countMatchingInputs);
        flag = checkExpectedListCount(countMatchingInputs, iterations, flag);
        return flag;
    }

    /*
   Method Implementation of Fixed Point Method, the method takes in a FixedPoint object
   and through the Fixed Point Method creates its own list of outputs, and compares that list
   with the list of inputs from the user, if the list matches within 3 significant digits of
   the correct answer, for all the numbers entered by the client, then it returns true.
    */
    @Override
    public boolean checkDataFixedPointMethod(FixedPointDto fixedPointDto){
        boolean flag = false;
        int i = 0;
        double xk = fixedPointDto.getXo();
        double x = 0.0;
        int decimalPoint = 3;
        int countMatchingInputs = 0;
        int iterations = fixedPointDto.getIterations();
        List<Double> inputs = fixedPointDto.getInp();
        List<Double> listToCheck = new ArrayList<>();
        String problemString = fixedPointDto.getProblemString();
        for(i=0;i<iterations;i++){
            x = fx(xk,problemString);
            x = truncateDecimalPlaces(x,decimalPoint);
            listToCheck.add(x);
            xk = x;
        }
        countMatchingInputs = CheckIfInputsMatch(inputs,listToCheck,countMatchingInputs);
        flag = checkExpectedListCount(countMatchingInputs,iterations,flag);
        return flag;
    }

}
