package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.DirectEulerDto;
import com.example.allTheMethods.dto.request.ImprovedEulerDto;
import com.example.allTheMethods.dto.request.RungeKuttaDataDto;
import com.example.allTheMethods.dto.request.RungeKuttaNystromDto;
import com.example.allTheMethods.service.SubmissionServiceDifferentialEquations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/submissions")
public class DifferentialEquationsSubmissionController {
    private SubmissionServiceDifferentialEquations submissionServiceDifferentialEquations;
    public DifferentialEquationsSubmissionController(SubmissionServiceDifferentialEquations submissionServiceDifferentialEquations){
        this.submissionServiceDifferentialEquations = submissionServiceDifferentialEquations;
    }

    @PostMapping("/rungeKutta")
    public ResponseEntity<?> rungeKutta(@RequestBody RungeKuttaDataDto rungeKuttaDataDto){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.rungeKutta(rungeKuttaDataDto), HttpStatus.OK);
    }

    @PostMapping("/improvedEuler")
    public ResponseEntity<?> improvedEuler(@RequestBody ImprovedEulerDto improvedEulerDto){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.improvedEuler(improvedEulerDto), HttpStatus.OK);
    }

    @PostMapping("/directEuler")
    public ResponseEntity<?> directEuler(@RequestBody DirectEulerDto directEulerDto){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.directEuler(directEulerDto), HttpStatus.OK);
    }

    @PostMapping("/rungeKuttaN")
    public ResponseEntity<?> rungeKuttaNystrom(@RequestBody RungeKuttaNystromDto rungeKuttaNystromDto){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.rungeKuttaNystrom(rungeKuttaNystromDto), HttpStatus.OK);
    }
}
