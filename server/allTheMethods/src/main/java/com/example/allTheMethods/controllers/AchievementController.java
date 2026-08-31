package com.example.allTheMethods.controllers;
import com.example.allTheMethods.dto.request.CreateAchievementRequestDto;
import com.example.allTheMethods.dto.request.UpdateAchievementRequestDto;
import com.example.allTheMethods.dto.response.AchievementResponseDto;
import com.example.allTheMethods.service.AchievementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AchievementResponseDto> createAchievement(@Valid @RequestBody CreateAchievementRequestDto achievementDto){
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

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AchievementResponseDto> updateAchievement(@Valid @PathVariable("id") Long id, @RequestBody UpdateAchievementRequestDto updateAchievementDto){
        System.out.println(updateAchievementDto);
        AchievementResponseDto achievementDto = achievementService.updateAchievement(id, updateAchievementDto);
        return ResponseEntity.ok(achievementDto);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
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
