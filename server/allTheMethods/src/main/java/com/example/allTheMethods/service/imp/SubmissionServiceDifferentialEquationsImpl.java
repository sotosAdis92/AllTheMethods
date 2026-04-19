package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.RungeKuttaDataDto;
import com.example.allTheMethods.dto.RungeKuttaNystromDto;
import com.example.allTheMethods.service.SubmissionServiceDifferentialEquations;

public class SubmissionServiceDifferentialEquationsImpl implements SubmissionServiceDifferentialEquations {
    @Override
    public boolean checkRungeKuttaData(RungeKuttaDataDto rungeKuttaDataDto) {
        boolean flag = false;

        return flag;
    }

    @Override
    public boolean checkRungeKuttaNystromData(RungeKuttaNystromDto rungeKuttaNystromDto) {
        return false;
    }

    @Override
    public boolean checkImprovedEulerData() {
        return false;
    }

    @Override
    public boolean checkDirectEulerData() {
        return false;
    }
}
