package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.TrapezodialRuleDataDto;
import com.example.allTheMethods.service.SubmissionServiceIntegrals;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import static com.example.allTheMethods.service.imp.SubmissionServiceImpl.fx;

@Service
public class SubmissionServiceIntegralsImpl implements SubmissionServiceIntegrals {

    @Override
    public boolean checkTrapezodialRuleData(TrapezodialRuleDataDto trapezodialRuleDataDto) {
        boolean flag = false;
        int integrationPointA = trapezodialRuleDataDto.getIntegrationPointA();
        int integrationPointB = trapezodialRuleDataDto.getIntegrationPointB();
        String problemString = trapezodialRuleDataDto.getProblemString();
        int hParameter = trapezodialRuleDataDto.gethParameter();
        int i = 0;
        double finalCount=0;
        ArrayList<Double> generatedList = new ArrayList<>();
        ArrayList<Double> listToCheck = new ArrayList<>();


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

        System.out.println(listToCheck);
        System.out.println(finalCount);

        return flag;
    }

    @Override
    public boolean checkSimpsonData() {
        return false;
    }

    @Override
    public boolean checkRombergData() {
        return false;
    }
}
