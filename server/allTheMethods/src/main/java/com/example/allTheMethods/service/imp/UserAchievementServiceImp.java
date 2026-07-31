package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.SaveUserAchievementDto;
import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.dto.response.UserAchievementResponseDto;
import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.entity.UserAchievements;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.UserAchievementsMapper;
import com.example.allTheMethods.mapper.imp.UserAchievementsMapperImpl;
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
        private final UserAchievementsMapper userAchievementsMapper;

    public UserAchievementServiceImp(JWTUtil jwtUtil, UserAchievementsRepository userAchievementsRepository, UsersRepository usersRepository, AchievementRepository achievementRepository, UserAchievementsMapper userAchievementsMapper) {
        this.jwtUtil = jwtUtil;
        this.userAchievementsRepository = userAchievementsRepository;
        this.usersRepository = usersRepository;
        this.achievementRepository = achievementRepository;
        this.userAchievementsMapper = userAchievementsMapper;
    }

    @Override
    public UserAchievementResponseDto saveUserAchievements(SaveUserAchievementDto saveUserAchievementDto) {
        UserAchievementDto userAchievementDto = saveUserAchievementDto.getUserAchievementDto();
        UserProblemDto userProblemDto = saveUserAchievementDto.getUserProblemDto();
        AchievementDto achievementDto = saveUserAchievementDto.getAchievementDto();

        Long user = userProblemDto.getUserId();
        System.out.println(user);
        String category = userProblemDto.getCategory();
        Integer counter = 0;
        counter = achievementDto.getCounter();
        String categoryToCheck = userAchievementDto.getCategory();
        int result = 0;
        try{
            result = userAchievementsRepository.countProblemsByCategory(user, category);
        } catch (NullPointerException exception) {
            System.out.println("No problems solved yet, that's ok dont crash the whole axios network");
            return null;
        }
        System.out.println(user);
        System.out.println(category);
        System.out.println(counter + " counter");
        System.out.println(categoryToCheck);
        System.out.println("result"+result);
        System.out.println(category.equals(categoryToCheck));
        System.out.println(counter == result);
        if(category.equals(categoryToCheck) && counter<=result){
            Long achievementId = achievementDto.getAchievementId();
            boolean achievementAlreadySaved = userAchievementsRepository.existsByUserIdAndAchievementId(user,achievementId);
            if(achievementAlreadySaved){
                System.out.println("Achievement already earned");
                return null;
            }
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

            UserAchievements userAchievements = UserAchievementsMapperImpl.mapToUserAchievement(userAchievementDto1);
            UserAchievements savedAchievement = userAchievementsRepository.save(userAchievements);
            return userAchievementsMapper.toDto(savedAchievement);
        }
        else{
            return null;
        }
    }

    @Override
    public List<UserAchievementResponseDto> getUserAchievements(Long id) {
        Users user = jwtUtil.getLoggedInUser();
        if(user!=null){
            List<UserAchievements> result = userAchievementsRepository.findAllByUserId(id);
            return userAchievementsMapper.toDto(result);
        }
        throw new EntityNotFoundException("User not found");
    }
}
