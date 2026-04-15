package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.TrapezodialRuleDataDto;
import com.example.allTheMethods.service.SubmissionServiceIntegrals;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static com.example.allTheMethods.service.imp.SubmissionServiceImpl.fx;
import static com.example.allTheMethods.service.imp.SubmissionServiceImpl.CheckIfInputsMatch;
import static com.example.allTheMethods.service.imp.SubmissionServiceImpl.checkExpectedListCount;
@Service
public class SubmissionServiceIntegralsImpl implements SubmissionServiceIntegrals {

    @Override
    public boolean checkTrapezodialRuleData(TrapezodialRuleDataDto trapezodialRuleDataDto) {
        boolean flag = false;
        int countMatchingInputs=0;
        int integrationPointA = trapezodialRuleDataDto.getIntegrationPointA();
        int integrationPointB = trapezodialRuleDataDto.getIntegrationPointB();
        String problemString = trapezodialRuleDataDto.getProblemString();
        int hParameter = trapezodialRuleDataDto.gethParameter();
        int i = 0;
        double finalCount=0;
        List<Double> userInputs = trapezodialRuleDataDto.getInp();
        List<Double> generatedList = new ArrayList<>();
        List<Double> listToCheck = new ArrayList<>();


        //Generate a list of the numbers used in the method
        for(i=integrationPointA;i<=integrationPointB;i++){
            double x = i;
            x = fx(x, problemString);
            generatedList.add(x);
        }

        //To avoid if, else if, else statement we implemented this version
        for(i=0;i<generatedList.size();i++){
            listToCheck.add(generatedList.get(i) * 2);
        }
        listToCheck.set(0, listToCheck.get(0)/2);
        listToCheck.set(listToCheck.size()-1, listToCheck.get(listToCheck.size()-1)/2);

        for(i=0;i<listToCheck.size();i++){
            finalCount = finalCount + listToCheck.get(i);
        }

        finalCount = finalCount * (hParameter/2);

        countMatchingInputs = CheckIfInputsMatch(userInputs, listToCheck, countMatchingInputs);
        flag = checkExpectedListCount(countMatchingInputs,listToCheck.size(),flag);

        System.out.println(listToCheck);
        System.out.println(finalCount);

        return flag;
    }

    @Override
    public boolean checkSimpsonData() {
        boolean flag = false;
        int integrationSpaceA = ;
        int integrationSpaceB = ;
        List<Double> inputsFromUser = ;

        return flag;
    }

    @Override
    public boolean checkRombergData() {
        return false;
    }
}
