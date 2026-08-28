package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.GershgorinCircleDataDto;
import com.example.allTheMethods.dto.request.LinearSystemsDataDto;
import com.example.allTheMethods.service.SubmissionServiceLinearSystems;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubmissionServiceLinearSystemsImpl implements SubmissionServiceLinearSystems {

    @Override
    public boolean gershgorinCirclesAlgorithm(LinearSystemsDataDto linearSystemsDataDto) {
        int[][] matrix = linearSystemsDataDto.matrix();
        int i = 0;
        int j = 0;
        List<Integer> rowSums = new ArrayList<>();
        List<Integer> colSums = new ArrayList<>();
        List<Integer> mins = new ArrayList<>();
        List<Integer> diag = new ArrayList<>();
        int sum = 0;
        int sumCols = 0;
        for(i=0;i<matrix.length;i++){
            sum = 0;
            sumCols = 0;
            for(j=0;j<matrix[i].length;j++){
                if(i!=j){
                    sum = sum + Math.abs(matrix[i][j]);
                    sumCols = sumCols + Math.abs(matrix[j][i]);
                }
                else{
                    diag.add(matrix[i][j]);
                }
            }
            colSums.add(sumCols);
            rowSums.add(sum);
        }

        for(i=0;i<matrix.length;i++){
            mins.add(Math.min(rowSums.get(i),colSums.get(i)));
        }
        for(i=0;i<3;i++){
            System.out.println(mins.get(i));
        }
        return false;
    }
}
