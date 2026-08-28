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
        double[][] matrix = linearSystemsDataDto.matrix();
        int i = 0;
        int j = 0;
        List<Double> rowSums = new ArrayList<>();
        List<Double> colSums = new ArrayList<>();
        List<Double> mins = new ArrayList<>();
        List<Double> diag = new ArrayList<>();
        List<Double> diagMinus = new ArrayList<>();
        List<Double> diagPlus = new ArrayList<>();
        List<Double> listToCheck = new ArrayList<>();

        double sum = 0;
        double sumCols = 0;
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

        for(i=0;i< matrix.length;i++){
            diagMinus.add(diag.get(i) - mins.get(i));
            diagPlus.add(diag.get(i) + mins.get(i));
        }


        return false;
    }
}
