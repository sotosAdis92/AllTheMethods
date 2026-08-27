package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.GershgorinCircleDataDto;
import com.example.allTheMethods.dto.request.LinearSystemsDataDto;
import com.example.allTheMethods.service.SubmissionServiceLinearSystems;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceLinearSystemsImpl implements SubmissionServiceLinearSystems {

    @Override
    public boolean gershgorinCirclesAlgorithm(LinearSystemsDataDto linearSystemsDataDto) {
        int[][] matrix = linearSystemsDataDto.matrix();
        int i = 0;
        int j = 0;
        return false;
    }
}
