package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.service.UserProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user/problems")
public class UserProblemController {
    private final UserProblemService userProblemService;

    public UserProblemController(UserProblemService userProblemService) {
        this.userProblemService = userProblemService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserProblemDto> saveUserProblem(@RequestBody UserProblemDto userProblemDto){
        UserProblemDto userProblemDto1 = userProblemService.saveUserProblem(userProblemDto);
        return new ResponseEntity<>(userProblemDto1, HttpStatus.CREATED);
    }

    @GetMapping("/myproblems/{id}")
    public ResponseEntity<?> getMyProblems(){
        return ResponseEntity.ok(userProblemService.getUserProblems());
    }

    @GetMapping("/check/{id}")
    public boolean checkIfUserSolvedAProblem(@PathVariable int id){
        return userProblemService.checkIfUserSolvedAProblem(id);
    }

    @GetMapping("/difficulty/{id}")
    public ResponseEntity<List<Object>> getCountAllProblemsOfUserByDifficulty(@PathVariable("id") int id){
        List<Object> count = userProblemService.countAllByUserAndProblemDifficulty(id);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/count/{id}")
    public ResponseEntity<List<Object>> countDistinctSolvedProblemsByDifficultyForUser(@PathVariable("id") int id){
        List<Object> countDistinct = userProblemService.countDistinctSolvedProblemsByDifficultyForUser(id);
        return ResponseEntity.ok(countDistinct);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Object>> countDistinctSolvedProblemsByCategory(@PathVariable("id") int id){
        System.out.println(id);
        List<Object> countDistinct = userProblemService.countDistinctSolvedProblemsByCategoryForUser(id);
        return ResponseEntity.ok(countDistinct);
    }

}
