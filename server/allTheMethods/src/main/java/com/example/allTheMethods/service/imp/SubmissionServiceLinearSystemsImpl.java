package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.GerschgorinCirclesDto;
import com.example.allTheMethods.service.SubmissionServiceLinearSystems;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceLinearSystemsImpl implements SubmissionServiceLinearSystems {
    @Override
    public boolean checkGerschgorinCircleData(GerschgorinCirclesDto gerschgorinCirclesDto) {
        boolean flag = false;
        int[][] inputs = gerschgorinCirclesDto.getInputMatrix();
        int n = gerschgorinCirclesDto.getnSize();
        int m = gerschgorinCirclesDto.getmSize();
        int[] sumOfRows = new int[n];
        int[] sumOfColumns = new int[m];
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
        return flag;
    }
}
