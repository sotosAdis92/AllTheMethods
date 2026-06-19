package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.GerschgorinCirclesDto;
import com.example.allTheMethods.service.SubmissionServiceLinearSystems;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static com.example.allTheMethods.utils.MethodUtils.CheckIfInputsMatch;
import static com.example.allTheMethods.utils.MethodUtils.checkExpectedListCount;

@Service
public class SubmissionServiceLinearSystemsImpl implements SubmissionServiceLinearSystems {
    @Override
    public boolean checkGerschgorinCircleData(GerschgorinCirclesDto gerschgorinCirclesDto) {
        boolean flag = false;
        int[][] inputs = gerschgorinCirclesDto.getInputMatrix();
        int n = gerschgorinCirclesDto.getnSize();
        int m = gerschgorinCirclesDto.getmSize();
        List<Double> listToCheck = new ArrayList<>();
        List<Double> userInputs = gerschgorinCirclesDto.getInp();
        int countMatchingInputs = 0;
        int[] sumOfRows = new int[n];
        int[] sumOfColumns = new int[m];
        int[] mins = new int[n];
        int[] diagonals = new int[n];
        int[] rs = new int[n];
        int[] rprimes = new int[m];
        int sumOfRow = 0;
        int sumOfColumn = 0;
        int i = 0;
        int j = 0;


        for(i=0;i<inputs.length;i++){
            for(j=0;j<inputs[i].length;j++){
                if(i!=j){
                    sumOfRow = sumOfRow + Math.abs(inputs[i][j]);
                }
            }
            sumOfRows[i] = sumOfRow;
            sumOfRow = 0;
        }
        for(j=0;j<inputs.length;j++){
            for(i=0;i<inputs[j].length;i++){
                if(i!=j){
                    sumOfColumn = sumOfColumn + Math.abs(inputs[i][j]);
                }
            }
            sumOfColumns[j] = sumOfColumn;
            System.out.println(sumOfColumns[j]);
            sumOfColumn = 0;
        }
        for(i=0;i<sumOfRows.length;i++){
            diagonals[i] = inputs[i][i];
            if(sumOfRows[i]<sumOfColumns[i]){
                mins[i] = sumOfRows[i];
            }
            else{
                mins[i] = sumOfColumns[i];
            }
        }
        for(i=0;i<n;i++){
            rs[i] = diagonals[i] + mins[i];
            listToCheck.add((double)rs[i]);
        }
        for(i=0;i<m;i++){
            rprimes[i] = diagonals[i] - mins[i];
            listToCheck.add((double)rprimes[i]);
        }
        countMatchingInputs = CheckIfInputsMatch(userInputs, listToCheck, countMatchingInputs);
        flag = checkExpectedListCount(countMatchingInputs,listToCheck.size(),flag);
        return flag;
    }
}
