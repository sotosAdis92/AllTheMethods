package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.CreateSubmissionRequestDto;
import com.example.allTheMethods.dto.response.SubmissionResponse;
import com.example.allTheMethods.entity.Submission;
import com.example.allTheMethods.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    private final SubmissionService submissionService;
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<SubmissionResponse> createSubmission(@RequestBody CreateSubmissionRequestDto submissionDto){
        SubmissionResponse submission = submissionService.createSubmission(submissionDto);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Page<SubmissionResponse>> getSubmissionsByUserId(
            @PathVariable("id") int id,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<SubmissionResponse> submissions = submissionService.getSubmissionsByUserId(id, PageRequest.of(pageNo-1,pageSize));
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }
}
