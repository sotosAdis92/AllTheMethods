package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.DirectEulerRequest;
import com.example.allTheMethods.dto.request.ImprovedEulerRequest;
import com.example.allTheMethods.dto.request.RungeKuttaRequest;
import com.example.allTheMethods.dto.request.RungeKuttaNystromRequest;
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
    public ResponseEntity<?> rungeKutta(@RequestBody RungeKuttaRequest rungeKuttaRequest){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.rungeKutta(rungeKuttaRequest), HttpStatus.OK);
    }

    @PostMapping("/improvedEuler")
    public ResponseEntity<?> improvedEuler(@RequestBody ImprovedEulerRequest improvedEulerRequest){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.improvedEuler(improvedEulerRequest), HttpStatus.OK);
    }

    @PostMapping("/directEuler")
    public ResponseEntity<?> directEuler(@RequestBody DirectEulerRequest directEulerRequest){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.directEuler(directEulerRequest), HttpStatus.OK);
    }

    @PostMapping("/rungeKuttaN")
    public ResponseEntity<?> rungeKuttaNystrom(@RequestBody RungeKuttaNystromRequest rungeKuttaNystromRequest){
        return new ResponseEntity<>(submissionServiceDifferentialEquations.rungeKuttaNystrom(rungeKuttaNystromRequest), HttpStatus.OK);
    }
}
