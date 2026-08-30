package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.LinearSystemsDataDto;
import com.example.allTheMethods.service.SubmissionServiceLinearSystems;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class LinearSystemsSubmissionController {
    private SubmissionServiceLinearSystems submissionServiceLinearSystems;
    public LinearSystemsSubmissionController(SubmissionServiceLinearSystems submissionServiceLinearSystems){
        this.submissionServiceLinearSystems = submissionServiceLinearSystems;
    }

    @PostMapping("/gershgorin")
    public ResponseEntity<?> gershgorinCirclesAlgorithm(@RequestBody LinearSystemsDataDto linearSystemsDataDto){
        System.out.println(linearSystemsDataDto.matrix());
        return new ResponseEntity<>(submissionServiceLinearSystems.gershgorinCirclesAlgorithm(linearSystemsDataDto), HttpStatus.OK);
    }

}
