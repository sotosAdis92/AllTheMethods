package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.SaveUserAchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.service.UserAchievementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userAchievements")
@CrossOrigin("*")
public class UserAchievementsController {
    private final UserAchievementService userAchievementService;

    public UserAchievementsController(UserAchievementService userAchievementService) {
        this.userAchievementService = userAchievementService;
    }

    @PostMapping("/saveAchievements")
    public ResponseEntity<UserAchievementDto> saveUserAchievement(@RequestBody SaveUserAchievementDto saveUserAchievementDto){
        UserAchievementDto userAchievementDto1 = userAchievementService.saveUserAchievements(saveUserAchievementDto);
        return new ResponseEntity<>(userAchievementDto1, HttpStatus.CREATED);
    }

    @GetMapping("/myAchievements")
    public ResponseEntity<?> getMyAchievements(){
        return ResponseEntity.ok(userAchievementService.getUserAchievements());
    }
}
