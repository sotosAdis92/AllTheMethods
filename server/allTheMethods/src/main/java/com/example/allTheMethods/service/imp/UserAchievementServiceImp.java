package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.dto.UserProblemDto;
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
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

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
    public UserAchievementDto saveUserAchievements() {
        Long user = userProblemDto.getUserId();
        String category = userProblemDto.getCategory();
        int counter = achievementDto.getCounter();
        String categoryToCheck = userAchievementDto.getCategory();
        Object[] result = userAchievementsRepository.countProblemsByCategory(user);
        int countFromResult = 0;
        for(int i=0;i<result.length;i++){
            countFromResult = parseInt(result[1].toString());
        }
        if(category.equals(categoryToCheck) && counter == countFromResult){
            UserAchievements userAchievements = UserAchievementsMapper.mapToUserAchievement(userAchievementDto);
            UserAchievements savedAchievement = userAchievementsRepository.save(userAchievements);
            return UserAchievementsMapper.mapToUserAchievementDto(savedAchievement);
        }
        else{
            return null;
        }
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
