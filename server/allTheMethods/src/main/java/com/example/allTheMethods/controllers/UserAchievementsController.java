package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.SaveUserAchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.service.UserAchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userAchievements")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserAchievementsController {
    private final UserAchievementService userAchievementService;

    @PostMapping("/saveAchievements")
    public ResponseEntity<UserAchievementDto> saveUserAchievement(@RequestBody SaveUserAchievementDto saveUserAchievementDto){
        System.out.println("Hit endpoint user achievements");
        UserAchievementDto userAchievementDto1 = userAchievementService.saveUserAchievements(saveUserAchievementDto);
        return new ResponseEntity<>(userAchievementDto1, HttpStatus.CREATED);
    }

    @GetMapping("/myAchievements")
    public ResponseEntity<?> getMyAchievements(){
        return ResponseEntity.ok(userAchievementService.getUserAchievements());
    }
}
