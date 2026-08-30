package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.LinearSystemsDataDto;
import com.example.allTheMethods.service.SubmissionServiceLinearSystems;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static com.example.allTheMethods.utils.MethodUtils.CheckIfInputsMatch;
import static com.example.allTheMethods.utils.MethodUtils.checkExpectedListCount;

@Service
public class SubmissionServiceLinearSystemsImpl implements SubmissionServiceLinearSystems {

    @Override
    public boolean gershgorinCirclesAlgorithm(LinearSystemsDataDto linearSystemsDataDto) {
        List<List<Double>> matrix = linearSystemsDataDto.matrix();
        int i = 0;
        int j = 0;
        int countMatchingInputs = 0;

        boolean flag = false;

        List<Double> input = linearSystemsDataDto.inp();
        List<Double> rowSums = new ArrayList<>();
        List<Double> colSums = new ArrayList<>();
        List<Double> mins = new ArrayList<>();
        List<Double> diag = new ArrayList<>();
        List<Double> diagMinus = new ArrayList<>();
        List<Double> diagPlus = new ArrayList<>();
        List<Double> listToCheck = new ArrayList<>();

        double sum = 0;
        double sumCols = 0;
        for(i=0;i<matrix.size();i++){
            sum = 0;
            sumCols = 0;
            for(j=0;j<matrix.get(i).size();j++){
                if(i!=j){
                    sum = sum + Math.abs(matrix.get(i).get(j));
                    sumCols = sumCols + Math.abs(matrix.get(j).get(i));
                }
                else{
                    diag.add(matrix.get(i).get(j));
                }
            }
            colSums.add(sumCols);
            rowSums.add(sum);
        }

        for(i=0;i<matrix.size();i++){
            mins.add(Math.min(rowSums.get(i),colSums.get(i)));
        }

        for(i=0;i< matrix.size();i++){
            diagMinus.add(diag.get(i) - mins.get(i));
            diagPlus.add(diag.get(i) + mins.get(i));
        }

        for(i=0;i<diagMinus.size();i++){
            listToCheck.add(diagMinus.get(i));
            listToCheck.add(diagPlus.get(i));
        }
        countMatchingInputs = CheckIfInputsMatch(input,listToCheck,countMatchingInputs);
        flag = checkExpectedListCount(countMatchingInputs, diagMinus.size() + diagPlus.size(), flag);
        return flag;
    }
}
