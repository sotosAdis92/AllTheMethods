package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.SaveUserProblemRequest;
import com.example.allTheMethods.dto.response.*;
import com.example.allTheMethods.service.UserProblemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/user/problems")
public class UserProblemController {
    private final UserProblemService userProblemService;

    public UserProblemController(UserProblemService userProblemService) {
        this.userProblemService = userProblemService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserProblemResponse> saveUserProblem(@RequestBody SaveUserProblemRequest requestDto){
        UserProblemResponse userProblemDto = userProblemService.saveUserProblem(requestDto);
        return new ResponseEntity<>(userProblemDto, HttpStatus.CREATED);
    }

    @GetMapping("/myproblems/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<Page<UserProblemResponse>> getMyProblems(
            @PathVariable("id") int id,
            @RequestParam(defaultValue = "1", required = false, name = "pageNo") int pageNo,
            @RequestParam(defaultValue = "10", required = false, name = "pageSize") int pageSize
    ){
        Page<UserProblemResponse> userProblems = userProblemService.getUserProblemsByUserId(id, PageRequest.of(pageNo-1,pageSize));
        return new ResponseEntity<>(userProblems, HttpStatus.OK);
    }

    @GetMapping("/check/{id}")
    public boolean checkIfUserSolvedAProblem(@PathVariable("id") int id){
        return userProblemService.checkIfUserSolvedAProblem(id);
    }

    @GetMapping("/difficulty/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<List<DifficultyStatsResponse>> getCountAllProblemsOfUserByDifficulty(@PathVariable("id") int id){
        List<DifficultyStatsResponse> count = userProblemService.countAllByUserAndProblemDifficulty(id);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/points/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<Long> countTotalPointsOfUserWithId(@PathVariable("id") long id){
        Long countDistinct = userProblemService.countTotalPointsOfUser(id);
        return ResponseEntity.ok(countDistinct);
    }

    @GetMapping("/count/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<List<UserProblemStatsResponse>> countDistinctSolvedProblemsByDifficultyForUser(@PathVariable("id") int id){
        List<UserProblemStatsResponse> countDistinct = userProblemService.countDistinctSolvedProblemsByDifficultyForUser(id);
        return ResponseEntity.ok(countDistinct);
    }

    @GetMapping("/category/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<List<CategoryStatsResponse>> countDistinctSolvedProblemsByCategory(@PathVariable("id") int id){
        System.out.println(id);
        List<CategoryStatsResponse> countDistinct = userProblemService.countDistinctSolvedProblemsByCategoryForUser(id);
        return ResponseEntity.ok(countDistinct);
    }

    @GetMapping("/summary/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<SummaryResponse> getSummeryOfUser(@PathVariable("id") int id){
        SummaryResponse summery = userProblemService.countSummeryOfUser(id);
        return ResponseEntity.ok(summery);
    }

    @GetMapping("/type/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<UserProblemStatsResponse> countProblemsSolvedByUserAndType(@PathVariable("id") int id, @RequestParam(name = "type") String type){
        System.out.println(type);
        UserProblemStatsResponse userProblemStatsResponse = userProblemService.countProblemsByUserAndTypeAndDifficulty(id,type);
        return ResponseEntity.ok(userProblemStatsResponse);
    }
}
