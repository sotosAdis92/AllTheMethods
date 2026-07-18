package com.example.allTheMethods.controllers;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SubmissionController {
    private SubmissionService submissionService;

    @PostMapping
    public ResponseEntity<SubmissionDto> createSubmission(@RequestBody SubmissionDto submissionDto){
        SubmissionDto submission = submissionService.createSubmission(submissionDto);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }
}
