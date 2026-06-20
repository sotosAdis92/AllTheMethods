package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.DirectEulerDto;
import com.example.allTheMethods.dto.ImprovedEulerDto;
import com.example.allTheMethods.dto.RungeKuttaDataDto;
import com.example.allTheMethods.dto.RungeKuttaNystromDto;
import com.example.allTheMethods.service.SubmissionServiceDifferentialEquations;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class DifferentialEquationsSubmissionController {
    private SubmissionServiceDifferentialEquations submissionServiceDifferentialEquations;
    public DifferentialEquationsSubmissionController(SubmissionServiceDifferentialEquations submissionServiceDifferentialEquations){
        this.submissionServiceDifferentialEquations = submissionServiceDifferentialEquations;
    }

    @PostMapping("/rungeKutta")
    public boolean checkRungeKuttaData(@RequestBody RungeKuttaDataDto rungeKuttaDataDto){
        boolean flag;
        flag = submissionServiceDifferentialEquations.checkRungeKuttaData(rungeKuttaDataDto);
        return flag;
    }

    @PostMapping("/improvedEuler")
    public boolean checkImprovedEulerData(@RequestBody ImprovedEulerDto improvedEulerDto){
        boolean flag;
        flag = submissionServiceDifferentialEquations.checkImprovedEulerData(improvedEulerDto);
        return flag;
    }

    @PostMapping("/directEuler")
    public boolean checkDirectEulerData(@RequestBody DirectEulerDto directEulerDto){
        boolean flag;
        flag = submissionServiceDifferentialEquations.checkDirectEulerData(directEulerDto);
        return flag;
    }

    @PostMapping("/rungeKuttaN")
    public boolean checkRungeKuttaNystromData(@RequestBody RungeKuttaNystromDto rungeKuttaNystromDto){
        boolean flag;
        flag = submissionServiceDifferentialEquations.checkRungeKuttaNystromData(rungeKuttaNystromDto);
        return flag;
    }
}
