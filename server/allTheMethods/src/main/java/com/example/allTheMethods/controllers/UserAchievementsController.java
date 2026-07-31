package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.SaveUserAchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.dto.response.UserAchievementResponseDto;
import com.example.allTheMethods.service.UserAchievementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/achievements")
@CrossOrigin("*")
public class UserAchievementsController {
    private final UserAchievementService userAchievementService;

    public UserAchievementsController(UserAchievementService userAchievementService) {
        this.userAchievementService = userAchievementService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserAchievementResponseDto> saveUserAchievement(@RequestBody SaveUserAchievementDto saveUserAchievementDto){
        System.out.println("Hit endpoint user achievements");
        UserAchievementResponseDto userAchievementDto = userAchievementService.saveUserAchievements(saveUserAchievementDto);
        return new ResponseEntity<>(userAchievementDto, HttpStatus.CREATED);
    }

    @GetMapping("/myachievements/{id}")
    public ResponseEntity<?> getMyAchievements(@RequestParam("id") Long id){
        return ResponseEntity.ok(userAchievementService.getUserAchievements(id));
    }
}
