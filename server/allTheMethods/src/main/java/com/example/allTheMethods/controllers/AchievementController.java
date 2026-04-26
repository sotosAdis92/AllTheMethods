package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.AchievementDto;
import com.example.allTheMethods.dto.ProblemDto;
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
    public ResponseEntity<AchievementDto> createAchievement(@RequestBody AchievementDto achievementDto){
        AchievementDto savedAchievement = achievementService.createAchievement(achievementDto);
        return new ResponseEntity<>(savedAchievement, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AchievementDto> getAchievementById(@PathVariable("id") Long id){
        AchievementDto achievementDto = achievementService.getAchievementById(id);
        return ResponseEntity.ok(achievementDto);
    }

    @GetMapping
    public ResponseEntity<List<AchievementDto>> getAllAchievements(){
        List<AchievementDto> achievevments = achievementService.getAllAchievements();
        return ResponseEntity.ok(achievevments);
    }

    @PutMapping("{id}")
    public ResponseEntity<AchievementDto> updateAchievement(@PathVariable("id") Long id, @RequestBody AchievementDto updateAchievementDto){
        AchievementDto achievementDto = achievementService.updateAchievement(id, updateAchievementDto);
        return ResponseEntity.ok(achievementDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAchievement(@PathVariable("id") Long id){
        achievementService.deleteAchievement(id);
        return ResponseEntity.ok("Deleted problem");
    }

    @GetMapping("categories/{category}")
    public ResponseEntity<List<AchievementDto>> getAchievementsByCategory(@PathVariable("category") String category){
        List<AchievementDto> achievementDtos = achievementService.getAchievementByCategory(category);
        return ResponseEntity.ok(achievementDtos);
    }

    @GetMapping("ranks/{rank}")
    public ResponseEntity<List<AchievementDto>> getAchievementsByRank(@PathVariable("rank") String rank){
        List<AchievementDto> achievementDtos = achievementService.getAchievementByRank(rank);
        return ResponseEntity.ok(achievementDtos);
    }


}
