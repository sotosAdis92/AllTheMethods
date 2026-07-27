package com.example.allTheMethods.controllers;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{id}")
    public ResponseEntity<List<SubmissionDto>> getSubmissionsByUserId(@PathVariable("id") int id){
        List<SubmissionDto> submissions = submissionService.getSubmissionsByUserId(id);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }
}
