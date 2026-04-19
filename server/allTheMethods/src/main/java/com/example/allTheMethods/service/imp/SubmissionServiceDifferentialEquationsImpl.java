package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.RungeKuttaDataDto;
import com.example.allTheMethods.dto.RungeKuttaNystromDto;
import com.example.allTheMethods.service.SubmissionServiceDifferentialEquations;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.allTheMethods.service.imp.SubmissionServiceImpl.CheckIfInputsMatch;
import static com.example.allTheMethods.service.imp.SubmissionServiceImpl.checkExpectedListCount;

@Service
public class SubmissionServiceDifferentialEquationsImpl implements SubmissionServiceDifferentialEquations {
    @Override
    public boolean checkRungeKuttaData(RungeKuttaDataDto rungeKuttaDataDto) {
        boolean flag = false;
        int iterations = rungeKuttaDataDto.getIterations();
        double xZero = rungeKuttaDataDto.getxZero();
        double yZero = rungeKuttaDataDto.getyZero();
        double hParameter = rungeKuttaDataDto.gethParameter();
        String problemString = rungeKuttaDataDto.getProblemString();
        List<Double> input = rungeKuttaDataDto.getInp();
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
    public boolean checkRungeKuttaNystromData(RungeKuttaNystromDto rungeKuttaNystromDto) {
        return false;
    }

    @Override
    public boolean checkImprovedEulerData() {
        return false;
    }

    @Override
    public boolean checkDirectEulerData() {
        return false;
    }
    public double f(double x, double y,String problem){
        Expression expression = new ExpressionBuilder(problem).variables("x","y").build().setVariable("x",x).setVariable("y",y);
        double xParameter = expression.evaluate();
        return xParameter;
    }
}
