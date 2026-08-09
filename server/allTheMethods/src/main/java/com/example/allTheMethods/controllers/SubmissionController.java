package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.CreateSubmissionRequestDto;
import com.example.allTheMethods.dto.response.SubmissionResponse;
import com.example.allTheMethods.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    private static final Logger log = LoggerFactory.getLogger(SubmissionController.class);
    private final SubmissionService submissionService;
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<SubmissionResponse> createSubmission(@RequestBody CreateSubmissionRequestDto submissionDto){
        SubmissionResponse submission = submissionService.createSubmission(submissionDto);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<SubmissionResponse>> getAllSubmissions(
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "DESC") String sortDir
    ){
        Sort sort = null;
        sort = sortDir.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Page<SubmissionResponse> submissions = submissionService.getAllSubmissions(PageRequest.of(pageNo-1,pageSize, sort));
        log.debug("Getting user submissions: " + submissions);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<Page<SubmissionResponse>> getSubmissionsByUserId(
            @PathVariable("id") int id,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "30") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "DESC") String sortDir
    ){
        Sort sort = null;
        sort = sortDir.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Page<SubmissionResponse> submissions = submissionService.getSubmissionsByUserId(id, PageRequest.of(pageNo-1,pageSize, sort));
        log.debug("Getting user submissions for user: " + id);
        log.debug("Getting user submissions: " + submissions);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }
}
