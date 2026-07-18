package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.DirectEulerDto;
import com.example.allTheMethods.dto.ImprovedEulerDto;
import com.example.allTheMethods.dto.RungeKuttaDataDto;
import com.example.allTheMethods.dto.RungeKuttaNystromDto;
import com.example.allTheMethods.service.SubmissionServiceDifferentialEquations;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class DifferentialEquationsSubmissionController {
    private SubmissionServiceDifferentialEquations submissionServiceDifferentialEquations;

    @PostMapping("/rungeKutta")
    public ResponseEntity<?> checkRungeKuttaData(@RequestBody RungeKuttaDataDto rungeKuttaDataDto){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.checkRungeKuttaData(rungeKuttaDataDto), HttpStatus.OK);
    }

    @PostMapping("/improvedEuler")
    public ResponseEntity<?> checkImprovedEulerData(@RequestBody ImprovedEulerDto improvedEulerDto){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.checkImprovedEulerData(improvedEulerDto), HttpStatus.OK);
    }

    @PostMapping("/directEuler")
    public ResponseEntity<?> checkDirectEulerData(@RequestBody DirectEulerDto directEulerDto){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.checkDirectEulerData(directEulerDto), HttpStatus.OK);
    }

    @PostMapping("/rungeKuttaN")
    public ResponseEntity<?> checkRungeKuttaNystromData(@RequestBody RungeKuttaNystromDto rungeKuttaNystromDto){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.checkRungeKuttaNystromData(rungeKuttaNystromDto), HttpStatus.OK);
    }
}
