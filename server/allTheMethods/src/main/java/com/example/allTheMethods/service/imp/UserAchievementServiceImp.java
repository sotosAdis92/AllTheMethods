package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.SaveUserAchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.dto.UserProblemDto;
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
    public UserAchievementDto saveUserAchievements(SaveUserAchievementDto saveUserAchievementDto) {
        UserAchievementDto userAchievementDto = saveUserAchievementDto.getUserAchievementDto();
        UserProblemDto userProblemDto = saveUserAchievementDto.getUserProblemDto();
        AchievementDto achievementDto = saveUserAchievementDto.getAchievementDto();

        Long user = userProblemDto.getUserId();
        String category = userProblemDto.getCategory();
        Integer counter = 0;
        counter = achievementDto.getCounter();
        String categoryToCheck = userAchievementDto.getCategory();
        int result = 0;
        result = userAchievementsRepository.countProblemsByCategory(user);
        System.out.println(user);
        System.out.println(category);
        System.out.println(counter + " counter");
        System.out.println(categoryToCheck);
        System.out.println("result"+result);
        System.out.println(category.equals(categoryToCheck));
        System.out.println(counter == result);
        if(category.equals(categoryToCheck) && counter<=result){
            System.out.println("Condition Met, entered If");
            Achievement achievement = achievementRepository.findById(achievementDto.getAchievementId()).orElse(null);
            UserAchievementDto userAchievementDto1 = new UserAchievementDto();
            userAchievementDto1.setUserId(user);
            userAchievementDto1.setCategory(achievementDto.getCategory());
            userAchievementDto1.setName(achievementDto.getName());
            userAchievementDto1.setDescription(achievementDto.getDescription());
            userAchievementDto1.setRank(achievementDto.getRank());
            userAchievementDto1.setVisibility(achievementDto.getVisibility());
            userAchievementDto1.setCounter(achievementDto.getCounter());
            userAchievementDto1.setAchievementId(achievement.getAchievementId());

            UserAchievements userAchievements = UserAchievementsMapper.mapToUserAchievement(userAchievementDto1);
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
