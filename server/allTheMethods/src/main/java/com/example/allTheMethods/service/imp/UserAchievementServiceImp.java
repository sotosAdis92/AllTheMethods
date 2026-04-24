package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.entity.UserAchievements;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.UserAchievementsMapper;
import com.example.allTheMethods.repository.AchievementRepository;
import com.example.allTheMethods.repository.UserAchievementsRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.UserAchievementService;
import com.example.allTheMethods.utils.JWTUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAchievementServiceImp implements UserAchievementService {
        private final JWTUtil jwtUtil;
        private final UserAchievementsRepository userAchievementsRepository;
        private final UsersRepository usersRepository;
        private final AchievementRepository achievementRepository;

    public UserAchievementServiceImp(JWTUtil jwtUtil, UserAchievementsRepository userAchievementsRepository, UsersRepository usersRepository, AchievementRepository achievementRepository) {
        this.jwtUtil = jwtUtil;
        this.userAchievementsRepository = userAchievementsRepository;
        this.usersRepository = usersRepository;
        this.achievementRepository = achievementRepository;
    }

    @Override
    public UserAchievementDto saveUserAchievements(UserAchievementDto userAchievementDto) {
        UserAchievements userAchievements = UserAchievementsMapper.mapToUserAchievement(userAchievementDto);
        UserAchievements savedUserAchievement = userAchievementsRepository.save(userAchievements);
        return UserAchievementsMapper.mapToUserAchievementDto(savedUserAchievement);
    }

    @Override
    public List<UserAchievementDto> getUserAchievements() {
        Users user = jwtUtil.getLoggedInUser();
        if(user!=null){
            List<UserAchievements> result = userAchievementsRepository.findAllByUserId(user.getId());
            return result.stream().map(results -> UserAchievementsMapper.mapToUserAchievementDto(results)).collect(Collectors.toUnmodifiableList());
        }
        throw new EntityNotFoundException("User not found");
    }
}
