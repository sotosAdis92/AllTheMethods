package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.service.UserProblemService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/userProblems")
public class UserProblemController {
    private final UserProblemService userProblemService;

    public UserProblemController(UserProblemService userProblemService) {
        this.userProblemService = userProblemService;
    }

    @PostMapping("/saveProblem")
    public ResponseEntity<UserProblemDto> saveUserProblem(@RequestBody UserProblemDto userProblemDto){
        UserProblemDto userProblemDto1 = userProblemService.saveUserProblem(userProblemDto);
        return new ResponseEntity<>(userProblemDto1, HttpStatus.CREATED);
    }

    @GetMapping("/myProblems")
    public ResponseEntity<?> getMyProblems(){
        return ResponseEntity.ok(userProblemService.getUserProblems());
    }

}
