package com.example.allTheMethods.controllers;

import com.example.allTheMethods.service.UserAchievementService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userAchievements")
@CrossOrigin("*")
public class UserAchievementsController {
    private final UserAchievementService userAchievementService;

    public UserAchievementsController(UserAchievementService userAchievementService) {
        this.userAchievementService = userAchievementService;
    }
}
