package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.DirectEulerRequest;
import com.example.allTheMethods.dto.request.ImprovedEulerRequest;
import com.example.allTheMethods.dto.request.RungeKuttaRequest;
import com.example.allTheMethods.dto.request.RungeKuttaNystromRequest;
import com.example.allTheMethods.service.SubmissionServiceDifferentialEquations;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static com.example.allTheMethods.utils.MethodUtils.CheckIfInputsMatch;
import static com.example.allTheMethods.utils.MethodUtils.checkExpectedListCount;

@Service
public class SubmissionServiceDifferentialEquationsImpl implements SubmissionServiceDifferentialEquations {
    @Override
    public boolean rungeKutta(RungeKuttaRequest rungeKuttaRequest) {
        boolean flag = false;
        int iterations = rungeKuttaRequest.getIterations();
        double xZero = rungeKuttaRequest.getxZero();
        double yZero = rungeKuttaRequest.getyZero();
        double hParameter = rungeKuttaRequest.gethParameter();
        String problemString = rungeKuttaRequest.getProblemString();
        List<Double> input = rungeKuttaRequest.getInp();
        List<Double> listToCheck = new ArrayList<>();
        int countMatchingInputs = 0;
        double k1 = 0.0;
        double k2 = 0.0;
        double k3 = 0.0;
        double k4 = 0.0;
        int i = 0;


        for(i=0;i<iterations;i++){
            k1 = f(xZero + 0 * hParameter,yZero + 0 * hParameter,problemString);
            k2 = f(xZero + 0.5*hParameter,yZero + 0.5*hParameter*k1, problemString);
            k3 = f(xZero + 0.5 * hParameter, yZero + (0*k1 + 0.5*k2) * hParameter, problemString);
            k4 = f(xZero + 1*hParameter,yZero + hParameter * (0*k1 + 0*k2 + 1*k3),problemString);
            yZero = yZero + hParameter*((1.0/6.0) * k1 + (1.0/3.0) * k2 + (1.0/3.0) * k3 + (1.0/6.0) * k4);
            k1 = 0.0; k2 = 0.0; k3 = 0.0; k4 = 0.0;
            xZero = xZero + hParameter;
            listToCheck.add(yZero);
        }

        countMatchingInputs = CheckIfInputsMatch(input,listToCheck,countMatchingInputs); //Function that checks if the inputs given are the expected ones
        flag = checkExpectedListCount(countMatchingInputs, iterations, flag);//Function that checks if count is the same as length (valid inputs)
        return flag;
    }

    @Override
    public boolean rungeKuttaNystrom(RungeKuttaNystromRequest rungeKuttaNystromRequest) {
        boolean flag = false;
        int i = 0;
        int iterations = rungeKuttaNystromRequest.getIterations();
        double yZero = rungeKuttaNystromRequest.getyZero();
        double xZero = rungeKuttaNystromRequest.getxZero();
        double yPrimeZero = rungeKuttaNystromRequest.getyPrimeZero();
        double xPrimeZero = rungeKuttaNystromRequest.getxPrimeZero();
        double hParameter = rungeKuttaNystromRequest.gethParameter();
        String problemString = rungeKuttaNystromRequest.getProblemString();
        List<Double> listToCheck = new ArrayList<>();
        List<Double> listToCheckPrime = new ArrayList<>();
        List<Double> input = rungeKuttaNystromRequest.getInp();
        int countMatchingInputs = 0;
        double k1 = 0.0;
        double k2 = 0.0;
        double k3 = 0.0;
        for(i=0;i<iterations;i++){
            k1 = f(xZero,yZero,problemString);
            k2 = f(xZero + (0.5)*hParameter,yZero + (0.5)*hParameter*yPrimeZero+(1.0/8.0)*hParameter*hParameter*k1,problemString);
            k3 = f(xZero + hParameter, yZero + hParameter*yPrimeZero + (0.5)*hParameter*hParameter*k2,problemString);
            yZero = yZero + hParameter*yPrimeZero + (hParameter*hParameter)*((1.0/6.0) * k1 + (1.0/3.0) * k2);
            yPrimeZero = yPrimeZero + hParameter*((1.0/6.0)*k1 + (2.0/3.0)*k2 + (1.0/6.0)*k3);
            listToCheck.add(yZero);
            listToCheckPrime.add(yPrimeZero);
        }
        countMatchingInputs = CheckIfInputsMatch(input,listToCheck,countMatchingInputs); //Function that checks if the inputs given are the expected ones
        flag = checkExpectedListCount(countMatchingInputs, iterations, flag);//Function that checks if count is the same as length (valid inputs)
        return flag;
    }

    @Override
    public boolean improvedEuler(ImprovedEulerRequest improvedEulerRequest) {
        boolean flag = false;
        int i = 0;
        int iterations = improvedEulerRequest.getIterations();
        double yZero = improvedEulerRequest.getyZero();
        double xZero = improvedEulerRequest.getxZero();
        double hParameter = improvedEulerRequest.gethParameter();
        String problemString = improvedEulerRequest.getProblemString();
        List<Double> listToCheck = new ArrayList<>();
        List<Double> input = improvedEulerRequest.getInp();
        double xn = xZero;
        double yn = yZero;
        int countMatchingInputs = 0;

        for(i=0;i<iterations;i++){
            xZero = xZero + hParameter;
            yZero = yZero + (hParameter/2.0) * (f(xZero,yZero,problemString) + f(xn,yZero + hParameter * f(xZero+hParameter,yZero,problemString),problemString));
            listToCheck.add(yZero);
            System.out.println("Y= "+yZero);
        }

        countMatchingInputs = CheckIfInputsMatch(input,listToCheck,countMatchingInputs); //Function that checks if the inputs given are the expected ones
        flag = checkExpectedListCount(countMatchingInputs, iterations, flag);//Function that checks if count is the same as length (valid inputs)
        return flag;
    }

    @Override
    public boolean directEuler(DirectEulerRequest directEulerRequest) {
        boolean flag = false;
        int i = 0;
        int iterations = directEulerRequest.getIterations();
        double yZero = directEulerRequest.getyZero();
        double xZero = directEulerRequest.getxZero();
        double hParameter = directEulerRequest.gethParameter();
        String problemString = directEulerRequest.getProblemString();
        List<Double> listToCheck = new ArrayList<>();
        List<Double> input = directEulerRequest.getInp();
        int countMatchingInputs = 0;
        for(i=0;i<iterations;i++){
            yZero = yZero + hParameter * f(xZero,yZero,problemString);
            listToCheck.add(yZero);
        }
        countMatchingInputs = CheckIfInputsMatch(input,listToCheck,countMatchingInputs); //Function that checks if the inputs given are the expected ones
        flag = checkExpectedListCount(countMatchingInputs, iterations, flag);//Function that checks if count is the same as length (valid inputs)
        return flag;
    }
    public double f(double x, double y,String problem){
        Expression expression = new ExpressionBuilder(problem).variables("x","y").build().setVariable("x",x).setVariable("y",y);
        double xParameter = expression.evaluate();
        return xParameter;
    }
}
