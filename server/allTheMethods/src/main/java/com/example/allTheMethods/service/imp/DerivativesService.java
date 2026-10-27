package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.FivePointDerivativeRequest;
import com.example.allTheMethods.dto.request.RichardsonRequest;
import com.example.allTheMethods.dto.request.ThreePointDerivativeRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static com.example.allTheMethods.utils.MethodUtils.CheckIfInputsMatch;
import static com.example.allTheMethods.utils.MethodUtils.checkExpectedListCount;

@Service
public class DerivativesService {

    public boolean threePointDerivative(ThreePointDerivativeRequest threePointDerivativeRequest) {
        boolean flag = false;
        String typeOfDerivative = threePointDerivativeRequest.getTypeOfDerivative();
        List<Integer> fiParameters = threePointDerivativeRequest.getFiParameters();
        List<Integer> xiParameters = threePointDerivativeRequest.getXiParameters();
        List<Double> userInputs = threePointDerivativeRequest.getInp();
        List<Double> listToCheck = new ArrayList<>();
        double xoParameter = threePointDerivativeRequest.getXoParameter();
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


    public boolean fivePointDerivative(FivePointDerivativeRequest fivePointDerivativeRequest) {
        boolean flag = false;
        String typeOfDerivative = fivePointDerivativeRequest.getTypeOfDerivative();
        List<Integer> fiParameters = fivePointDerivativeRequest.getFiParameters();
        List<Integer> xiParameters = fivePointDerivativeRequest.getXiParameters();
        List<Double> userInputs = fivePointDerivativeRequest.getInp();
        List<Double> listToCheck = new ArrayList<>();
        double xoParameter = fivePointDerivativeRequest.getXoParameter();
        double hParameter = 0.0;
        double fprime = 0.0;
        double fsecondPrime = 0.0;
        int countMatchingInputs = 0;
        int indexOfXoParameter = 0;
        int i = 0;
        hParameter = xiParameters.get(1) - xiParameters.get(0);

        for(i = 0;i<xiParameters.size();i++){
            if(xiParameters.get(i) == xoParameter){
                indexOfXoParameter = i;
            }
        }
        if(typeOfDerivative.equals("fprime")){
            fprime = (1 * f(indexOfXoParameter-2,fiParameters) + (-8) * f(indexOfXoParameter-1,fiParameters) + 0 * f(indexOfXoParameter,fiParameters) + 8 * f(indexOfXoParameter+1,fiParameters) + (-1) * f(indexOfXoParameter+2,fiParameters))/(12*hParameter);
            listToCheck.add(fprime);
            System.out.println("result "+fprime);
            countMatchingInputs = CheckIfInputsMatch(userInputs,listToCheck, countMatchingInputs);
            flag = checkExpectedListCount(countMatchingInputs,listToCheck.size(),flag);

        }
        else{
            fsecondPrime = ((-1) * f(indexOfXoParameter-2,fiParameters) + (16) * f(indexOfXoParameter-1,fiParameters) + (-30) * f(indexOfXoParameter,fiParameters) + 16 * f(indexOfXoParameter+1,fiParameters) + (-1) * f(indexOfXoParameter+2,fiParameters))/(12*(hParameter * hParameter));
            listToCheck.add(fsecondPrime);
            countMatchingInputs = CheckIfInputsMatch(userInputs,listToCheck, countMatchingInputs);
            flag = checkExpectedListCount(countMatchingInputs,listToCheck.size(),flag);
        }
        return flag;
    }


    public boolean richardson(RichardsonRequest richardsonRequest) {
        boolean flag = false;
        List<Integer> fiParameters = richardsonRequest.getFiParameters();
        List<Integer> xiParameters = richardsonRequest.getXiParameters();
        List<Double> userInputs = richardsonRequest.getInp();
        List<Double> listToCheck = new ArrayList<>();
        double xoParameter = richardsonRequest.getXoParameter();
        int hParameter = richardsonRequest.gethParameter();
        int indexOfXoParameter = 0;
        int i;
        double fprimeForNormalH = 0.0;
        double fprimeForHalfH = 0.0;
        double Dih = 0.0;
        int countMatchingInputs = 0;
        for(i = 0;i<xiParameters.size();i++){
            if(xiParameters.get(i) == xoParameter){
                indexOfXoParameter = i;
            }
        }
        fprimeForHalfH = (-1 * f(indexOfXoParameter-1,fiParameters) + 0 * f(indexOfXoParameter,fiParameters) + 1 * f(indexOfXoParameter+1,fiParameters))/(hParameter/2);
        fprimeForNormalH = (-1 * f(indexOfXoParameter-1,fiParameters) + 0 * f(indexOfXoParameter,fiParameters) + 1 * f(indexOfXoParameter+1,fiParameters))/(hParameter);
        Dih = (Math.pow(4,1) * fprimeForHalfH - fprimeForNormalH)/(Math.pow(4,1) - 1) ;
        listToCheck.add(Dih);
        countMatchingInputs = CheckIfInputsMatch(userInputs,listToCheck, countMatchingInputs);
        flag = checkExpectedListCount(countMatchingInputs,listToCheck.size(),flag);
        return flag;
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
