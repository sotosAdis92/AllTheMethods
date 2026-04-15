package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.TrapezodialRuleDataDto;
import com.example.allTheMethods.service.SubmissionServiceIntegrals;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

        ArrayList<Double> listToCheck = new ArrayList<>();
        for(i=integrationPointA;i<=integrationPointB;i++){
            double x = i;
            listToCheck.add(x);
        }


        return false;
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
