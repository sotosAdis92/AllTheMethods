package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.repository.AchievementRepository;
import com.example.allTheMethods.repository.UserAchievementsRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.UserAchievementService;
import com.example.allTheMethods.utils.JWTUtil;
import org.springframework.stereotype.Service;

@Service
public class UserAchievementServiceImp implements UserAchievementService {
        private final JWTUtil jwtUtil;
        private final UserAchievementsRepository achievementsRepository;
        private final UsersRepository usersRepository;
        private final AchievementRepository achievementRepository;

    public UserAchievementServiceImp(JWTUtil jwtUtil, UserAchievementsRepository achievementsRepository, UsersRepository usersRepository, AchievementRepository achievementRepository) {
        this.jwtUtil = jwtUtil;
        this.achievementsRepository = achievementsRepository;
        this.usersRepository = usersRepository;
        this.achievementRepository = achievementRepository;
    }
}
