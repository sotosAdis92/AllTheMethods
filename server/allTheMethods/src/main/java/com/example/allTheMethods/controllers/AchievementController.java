package com.example.allTheMethods.controllers;
import com.example.allTheMethods.dto.request.CreateAchievementRequestDto;
import com.example.allTheMethods.dto.request.UpdateAchievementRequestDto;
import com.example.allTheMethods.dto.response.AchievementResponseDto;
import com.example.allTheMethods.service.AchievementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/achievements")
public class AchievementController {
    private AchievementService achievementService;
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }


    @PostMapping
    public ResponseEntity<AchievementResponseDto> createAchievement(@RequestBody CreateAchievementRequestDto achievementDto){
        AchievementResponseDto savedAchievement = achievementService.createAchievement(achievementDto);
        return new ResponseEntity<>(savedAchievement, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AchievementResponseDto> getAchievementById(@PathVariable("id") Long id){
        AchievementResponseDto achievementDto = achievementService.getAchievementById(id);
        return ResponseEntity.ok(achievementDto);
    }

    @GetMapping
    public ResponseEntity<List<AchievementResponseDto>> getAllAchievements(){
        List<AchievementResponseDto> achievevments = achievementService.getAllAchievements();
        return ResponseEntity.ok(achievevments);
    }

    @PutMapping("{id}")
    public ResponseEntity<AchievementResponseDto> updateAchievement(@PathVariable("id") Long id, @RequestBody UpdateAchievementRequestDto updateAchievementDto){
        AchievementResponseDto achievementDto = achievementService.updateAchievement(id, updateAchievementDto);
        return ResponseEntity.ok(achievementDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAchievement(@PathVariable("id") Long id){
        achievementService.deleteAchievement(id);
        return ResponseEntity.ok("Deleted problem");
    }

    @GetMapping("categories/{category}")
    public ResponseEntity<List<AchievementResponseDto>> getAchievementsByCategory(@PathVariable("category") String category){
        List<AchievementResponseDto> achievementDtos = achievementService.getAchievementByCategory(category);
        return ResponseEntity.ok(achievementDtos);
    }

    @GetMapping("ranks/{rank}")
    public ResponseEntity<List<AchievementResponseDto>> getAchievementsByRank(@PathVariable("rank") String rank){
        List<AchievementResponseDto> achievementDtos = achievementService.getAchievementByRank(rank);
        return ResponseEntity.ok(achievementDtos);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AchievementResponseDto>> getAchievementsByCategoryAndRank(@RequestParam(required = false) List<String> categories, @RequestParam(required = false) List<String> ranks){
        List<AchievementResponseDto> achievementDtos = achievementService.getAchievementByCategoryAndRanks(categories,ranks);
        return ResponseEntity.ok(achievementDtos);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getAllAchievementsCount(){
        long countOfAchievements = achievementService.countAllTheAchievements();
        return ResponseEntity.ok(countOfAchievements);
    }


}
