package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.LinearSystemsRequest;
import com.example.allTheMethods.service.imp.LinearSystemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/submissions")
public class LinearSystemsSubmissionController {
    private LinearSystemsService submissionServiceLinearSystems;
    public LinearSystemsSubmissionController(LinearSystemsService submissionServiceLinearSystems){
        this.submissionServiceLinearSystems = submissionServiceLinearSystems;
    }

    @PostMapping("/gershgorin")
    public ResponseEntity<?> gershgorinCirclesAlgorithm(@RequestBody LinearSystemsRequest linearSystemsRequest){
        return new ResponseEntity<>(submissionServiceLinearSystems.gershgorinCirclesAlgorithm(linearSystemsRequest), HttpStatus.OK);
    }

}
