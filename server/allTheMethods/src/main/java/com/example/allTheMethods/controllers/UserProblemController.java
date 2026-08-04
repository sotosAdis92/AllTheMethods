package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.SaveUserProblemRequestDto;
import com.example.allTheMethods.dto.response.CategoryStatsResponseDto;
import com.example.allTheMethods.dto.response.DifficultyStatsResponse;
import com.example.allTheMethods.dto.response.UserProblemResponse;
import com.example.allTheMethods.dto.response.UserProblemStatsResponseDto;
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
    public ResponseEntity<UserProblemResponse> saveUserProblem(@RequestBody SaveUserProblemRequestDto requestDto){
        UserProblemResponse userProblemDto = userProblemService.saveUserProblem(requestDto);
        return new ResponseEntity<>(userProblemDto, HttpStatus.CREATED);
    }

    @GetMapping("/myproblems/{id}")
    public ResponseEntity<List<UserProblemResponse>> getMyProblems(
            @PathVariable("id") int id
    ){
        return ResponseEntity.ok(userProblemService.getUserProblemsByUserId(id));
    }

    @GetMapping("/check/{id}")
    public boolean checkIfUserSolvedAProblem(@PathVariable("id") int id){
        return userProblemService.checkIfUserSolvedAProblem(id);
    }

    @GetMapping("/difficulty/{id}")
    public ResponseEntity<List<DifficultyStatsResponse>> getCountAllProblemsOfUserByDifficulty(@PathVariable("id") int id){
        List<DifficultyStatsResponse> count = userProblemService.countAllByUserAndProblemDifficulty(id);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/count/{id}")
    public ResponseEntity<List<UserProblemStatsResponseDto>> countDistinctSolvedProblemsByDifficultyForUser(@PathVariable("id") int id){
        List<UserProblemStatsResponseDto> countDistinct = userProblemService.countDistinctSolvedProblemsByDifficultyForUser(id);
        return ResponseEntity.ok(countDistinct);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<CategoryStatsResponseDto>> countDistinctSolvedProblemsByCategory(@PathVariable("id") int id){
        System.out.println(id);
        List<CategoryStatsResponseDto> countDistinct = userProblemService.countDistinctSolvedProblemsByCategoryForUser(id);
        return ResponseEntity.ok(countDistinct);
    }

}
