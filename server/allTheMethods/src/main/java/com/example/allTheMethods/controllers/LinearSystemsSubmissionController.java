package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.GerschgorinCirclesDto;
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
    @PostMapping("/gerCircles")
    public ResponseEntity<?> checkGerschgorinCircleData(@RequestBody GerschgorinCirclesDto gerschgorinCirclesDto){
        return new ResponseEntity<>(submissionServiceLinearSystems.checkGerschgorinCircleData(gerschgorinCirclesDto), HttpStatus.OK);
    }
}
