package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.repository.UserAchievementsRepository;
import com.example.allTheMethods.service.UserAchievementService;
import com.example.allTheMethods.utils.JWTUtil;
import org.springframework.stereotype.Service;

@Service
public class UserAchievementServiceImp implements UserAchievementService {

    private final JWTUtil jwtUtil;
    private final UserAchievementsRepository userAchievementsRepository;
    private final UserAchievementService userAchievementService;

    public UserAchievementServiceImp(JWTUtil jwtUtil, UserAchievementsRepository userAchievementsRepository, UserAchievementService userAchievementService) {
        this.jwtUtil = jwtUtil;
        this.userAchievementsRepository = userAchievementsRepository;
        this.userAchievementService = userAchievementService;
    }
}
