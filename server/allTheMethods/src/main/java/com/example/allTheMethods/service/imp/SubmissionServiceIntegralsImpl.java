package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.RombergDataDto;
import com.example.allTheMethods.dto.SimpsonDataDto;
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
    /*
   Method Implementation of Trapezodial Rule, the method takes in a TrapezodialRule object
   and through the Trapezodial Rule creates its own list of outputs, and compares that list
   with the list of inputs from the user, if the list matches within 3 significant digits of
   the correct answer, for all the numbers entered by the client, then it returns true.
    */
    @Override
    public boolean checkTrapezodialRuleData(TrapezodialRuleDataDto trapezodialRuleDataDto) {
        boolean flag = false;
        int countMatchingInputs=0;
        int integrationPointA = trapezodialRuleDataDto.getIntegrationPointA();
        int integrationPointB = trapezodialRuleDataDto.getIntegrationPointB();
        String problemString = trapezodialRuleDataDto.getProblemString();
        double hParameter = trapezodialRuleDataDto.gethParameter();
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

    /*
    Method Implementation of Simpsons Method, the method takes in a Simpson object
    and through the Simpsons Method creates its own list of outputs, and compares that list
    with the list of inputs from the user, if the list matches within 3 significant digits of
    the correct answer, for all the numbers entered by the client, then it returns true.
    */
    @Override
    public boolean checkSimpsonData(SimpsonDataDto simpsonDataDto) {
        boolean flag = false;
        int integrationSpaceA = simpsonDataDto.getIntegrationSpaceA();
        int integrationSpaceB = simpsonDataDto.getIntegrationSpaceB();
        double hParameter = simpsonDataDto.gethParameter();
        List<Double> userInputs = simpsonDataDto.getInp();
        List<Double> generatedList = new ArrayList<>();
        String problemString = simpsonDataDto.getProblemString();
        int i = 0;
        double finalCount = 0;
        int countMatchingInputs = 0;
        for(i=integrationSpaceA;i<=integrationSpaceB;i++){
            double x = i;
            x = fx(x,problemString);
            if(i%2==0 && i!=integrationSpaceA && i!=integrationSpaceB){
                x = x * 2;
            }
            else{
                x = x * 4;
            }
            generatedList.add(x);
        }
        for(i=0;i<generatedList.size();i++){
            finalCount = finalCount + generatedList.get(i);
        }
        finalCount = finalCount * (hParameter/3);

        countMatchingInputs = CheckIfInputsMatch(userInputs, generatedList, countMatchingInputs);
        flag = checkExpectedListCount(countMatchingInputs,generatedList.size(),flag);

        System.out.println(generatedList);
        System.out.println(finalCount);

        return flag;
    }


    /*
    Method Implementation of Romberg Integration Method, the method takes in a Romberg object
    and through the Romberg Integration Method creates its own list of outputs, and compares that list
    with the list of inputs from the user, if the list matches within 3 significant digits of
    the correct answer, for all the numbers entered by the client, then it returns true.
    */
    @Override
    public boolean checkRombergData(RombergDataDto rombergDataDto) {
        boolean flag = false;
        int countMatchingInputs=0;

        List<Double> userInputs = rombergDataDto.getInp();
        List<Double> generatedList = new ArrayList<>();
        double[][] inputs = new double[userInputs.size()][userInputs.size()];

        int i = 0;
        int j = 0;

        while(j<inputs.length){
            while(i<inputs[j].length){
                System.out.println(inputs[i][j]);
                i++;
            }
            j++;
            i = 0 + j;

        }

        countMatchingInputs = CheckIfInputsMatch(userInputs, generatedList, countMatchingInputs);
        flag = checkExpectedListCount(countMatchingInputs,generatedList.size(),flag);
        return flag;
    }
}
