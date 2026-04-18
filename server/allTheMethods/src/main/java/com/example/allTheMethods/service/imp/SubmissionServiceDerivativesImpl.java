package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.FivePointDerivativeDto;
import com.example.allTheMethods.dto.RichardsonDataDto;
import com.example.allTheMethods.dto.ThreePointDerivativeDto;
import com.example.allTheMethods.service.SubmissionServiceDerivatives;

import java.util.ArrayList;
import java.util.List;

import static com.example.allTheMethods.service.imp.SubmissionServiceImpl.CheckIfInputsMatch;
import static com.example.allTheMethods.service.imp.SubmissionServiceImpl.checkExpectedListCount;

public class SubmissionServiceDerivativesImpl implements SubmissionServiceDerivatives {
    @Override
    public boolean checkThreePointDerivativeData(ThreePointDerivativeDto threePointDerivativeDto) {
        boolean flag = false;
        String typeOfDerivative = threePointDerivativeDto.getTypeOfDerivative();
        List<Integer> fiParameters = threePointDerivativeDto.getFiParameters();
        List<Integer> xiParameters = threePointDerivativeDto.getXiParameters();
        List<Double> userInputs = threePointDerivativeDto.getInp();
        List<Double> listToCheck = new ArrayList<>();
        double xoParameter = threePointDerivativeDto.getXoParameter();
        double hParameter = 0.0;
        double fprime = 0.0;
        double fsecondPrime = 0.0;
        int countMatchingInputs = 0;
        int indexOfXoParameter = 0;
        int i = 0;


        for(i = 0;i<xiParameters.size();i++){
            hParameter = xiParameters.get(i) - xiParameters.get(i-1);
            if(xiParameters.get(i) == xoParameter){
                indexOfXoParameter = i;
            }
        }
        System.out.println(hParameter);
        System.out.println(indexOfXoParameter);
        if(typeOfDerivative == "fprime"){
            fprime = (-1 * f(indexOfXoParameter-1,fiParameters) + 0 * f(indexOfXoParameter,fiParameters) + 1 * f(indexOfXoParameter+1,fiParameters))/(2*hParameter);
            listToCheck.add(fprime);
            countMatchingInputs = CheckIfInputsMatch(userInputs,listToCheck, countMatchingInputs);
            flag = checkExpectedListCount(countMatchingInputs,listToCheck.size(),flag);

        }
        else{
            fsecondPrime = (1 * f(indexOfXoParameter-1,fiParameters) + (-2) * f(indexOfXoParameter,fiParameters) + 1 * f(indexOfXoParameter + 1,fiParameters))/(hParameter * hParameter);
            listToCheck.add(fsecondPrime);
            countMatchingInputs = CheckIfInputsMatch(userInputs,listToCheck, countMatchingInputs);
            flag = checkExpectedListCount(countMatchingInputs,listToCheck.size(),flag);
        }
        return flag;
    }

    @Override
    public boolean checkFivePointDerivativeData(FivePointDerivativeDto fivePointDerivativeDto) {
        boolean flag = false;
        String typeOfDerivative = fivePointDerivativeDto.getTypeOfDerivative();
        List<Integer> fiParameters = fivePointDerivativeDto.getFiParameters();
        List<Integer> xiParameters = fivePointDerivativeDto.getXiParameters();
        List<Double> userInputs = fivePointDerivativeDto.getInp();
        List<Double> listToCheck = new ArrayList<>();
        double xoParameter = fivePointDerivativeDto.getXoParameter();
        double hParameter = 0.0;
        double fprime = 0.0;
        double fsecondPrime = 0.0;
        int countMatchingInputs = 0;
        int indexOfXoParameter = 0;
        int i = 0;


        for(i = 0;i<xiParameters.size();i++){
            hParameter = xiParameters.get(i) - xiParameters.get(i-1);
            if(xiParameters.get(i) == xoParameter){
                indexOfXoParameter = i;
            }
        }
        System.out.println(hParameter);
        System.out.println(indexOfXoParameter);
        if(typeOfDerivative == "fprime"){
            fprime = (-1 * f(indexOfXoParameter-1,fiParameters) + 0 * f(indexOfXoParameter,fiParameters) + 1 * f(indexOfXoParameter+1,fiParameters))/(2*hParameter);
            listToCheck.add(fprime);
            countMatchingInputs = CheckIfInputsMatch(userInputs,listToCheck, countMatchingInputs);
            flag = checkExpectedListCount(countMatchingInputs,listToCheck.size(),flag);

        }
        else{
            fsecondPrime = (1 * f(indexOfXoParameter-1,fiParameters) + (-2) * f(indexOfXoParameter,fiParameters) + 1 * f(indexOfXoParameter + 1,fiParameters))/(hParameter * hParameter);
            listToCheck.add(fsecondPrime);
            countMatchingInputs = CheckIfInputsMatch(userInputs,listToCheck, countMatchingInputs);
            flag = checkExpectedListCount(countMatchingInputs,listToCheck.size(),flag);
        }
        return flag;
    }

    @Override
    public boolean checkRichardsonData(RichardsonDataDto richardsonDataDto) {
        return false;
    }

    public int f(int indexOfXoParameter, List<Integer> fiParameters){
        int x = 0;
        int i = 0;
        for(i = 0;i<fiParameters.size();i++){
            if(i == indexOfXoParameter){
                x = fiParameters.get(i);
            }
        }
        return x;
    }
}
