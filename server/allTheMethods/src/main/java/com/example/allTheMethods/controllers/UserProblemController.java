package com.example.allTheMethods.controllers;

import com.example.allTheMethods.service.UserProblemService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/userProblems")
public class UserProblemController {
    private final UserProblemService userProblemService;

    public UserProblemController(UserProblemService userProblemService) {
        this.userProblemService = userProblemService;
    }

    @GetMapping("/myProblems")
    public ResponseEntity<?> getMyProblems(){
        return ResponseEntity.ok(userProblemService.getUserProblems());
    }

}
