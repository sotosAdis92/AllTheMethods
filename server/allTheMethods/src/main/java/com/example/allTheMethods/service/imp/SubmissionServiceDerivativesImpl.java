package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.FivePointDerivativeDto;
import com.example.allTheMethods.dto.RichardsonDataDto;
import com.example.allTheMethods.dto.ThreePointDerivativeDto;
import com.example.allTheMethods.service.SubmissionServiceDerivatives;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static com.example.allTheMethods.utils.MethodUtils.CheckIfInputsMatch;
import static com.example.allTheMethods.utils.MethodUtils.checkExpectedListCount;

@Service
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
        if(typeOfDerivative == "fprime"){
            fprime = (1 * f(indexOfXoParameter-2,fiParameters) + (-8) * f(indexOfXoParameter-1,fiParameters) + 0 * f(indexOfXoParameter,fiParameters) + 8 * f(indexOfXoParameter+1,fiParameters) + (-1) * f(indexOfXoParameter+2,fiParameters))/(12*hParameter);
            listToCheck.add(fprime);
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

    @Override
    public boolean checkRichardsonData(RichardsonDataDto richardsonDataDto) {
        boolean flag = false;
        List<Integer> fiParameters = richardsonDataDto.getFiParameters();
        List<Integer> xiParameters = richardsonDataDto.getXiParameters();
        List<Double> userInputs = richardsonDataDto.getInp();
        List<Double> listToCheck = new ArrayList<>();
        double xoParameter = richardsonDataDto.getXoParameter();
        int hParameter = richardsonDataDto.gethParameter();
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
