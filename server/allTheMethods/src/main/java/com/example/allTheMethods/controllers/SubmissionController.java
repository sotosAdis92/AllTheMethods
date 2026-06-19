package com.example.allTheMethods.controllers;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    private SubmissionService submissionService;
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<SubmissionDto> createSubmission(@RequestBody SubmissionDto submissionDto){
        SubmissionDto submission = submissionService.createSubmission(submissionDto);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
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

    @PostMapping("/gerCircles")
    public boolean checkGerschgorinCircleData(@RequestBody GerschgorinCirclesDto gerschgorinCirclesDto){
        boolean flag;
        flag = submissionServiceLinearSystems.checkGerschgorinCircleData(gerschgorinCirclesDto);
        return flag;
    }
}
