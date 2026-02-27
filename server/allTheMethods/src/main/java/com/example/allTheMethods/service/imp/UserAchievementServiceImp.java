package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.UserAchievementDto;
import com.example.allTheMethods.entity.Achievement;
import com.example.allTheMethods.entity.UserAchievements;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.repository.AchievementRepository;
import com.example.allTheMethods.repository.UserAchievementsRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.UserAchievementService;
import com.example.allTheMethods.utils.JWTUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
    public UserAchievementDto getUserAchievementInService(UserAchievements userAchievements){
        Users loggedInUser = jwtUtil.getLoggedInUser();
        UserAchievementDto userAchievementDto = new UserAchievementDto();
        userAchievementDto.setUserAchievementId(userAchievements.getUserAchievementId());
        userAchievementDto.setAchievedAt(userAchievements.getAchievedAt());

        Users achievementOwner = userAchievements.getUser();
        Achievement achievementOwned = userAchievements.getAchievement();

        if(loggedInUser != null && loggedInUser.getUserId().equals(achievementOwner.getUserId())){

        } else {

        }

        userAchievementDto.setUserId(achievementOwner.getUserId());
        userAchievementDto.setAchievementId(achievementOwned.getAchievementId());

        return userAchievementDto;
    }

    @Override
    public List<UserAchievementDto> getUserAchievements() {
        Users user = jwtUtil.getLoggedInUser();
        if(user!=null){
            return userAchievementsRepository.findAllByUserId(user.getUserId()).stream().sorted(Comparator.comparing(UserAchievements::getAchievedAt).reversed())
                    .map(this::getUserAchievementInService).collect(Collectors.toList());
        }
        throw new EntityNotFoundException("User not found");
    }
}
