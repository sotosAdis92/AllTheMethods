package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.SaveUserProblemRequestDto;
import com.example.allTheMethods.dto.response.UserProblemResponse;
import com.example.allTheMethods.service.UserProblemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Page<UserProblemResponse>> getMyProblems(
            @PathVariable("id") int id,
            @RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir
    ){
        Sort sort = null;
        sort = sortDir.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Page<UserProblemResponse> userProblemResponses = userProblemService.getUserProblemsByUserId(id, PageRequest.of(pageNo-1,pageSize,sort));
        return new ResponseEntity<>(userProblemResponses, HttpStatus.OK);
    }

    @GetMapping("/check/{id}")
    public boolean checkIfUserSolvedAProblem(@PathVariable("id") int id){
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
