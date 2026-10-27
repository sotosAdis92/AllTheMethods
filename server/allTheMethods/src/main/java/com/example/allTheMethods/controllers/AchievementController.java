package com.example.allTheMethods.controllers;
import com.example.allTheMethods.dto.request.CreateAchievementRequest;
import com.example.allTheMethods.dto.request.UpdateAchievementRequest;
import com.example.allTheMethods.dto.response.AchievementResponse;
import com.example.allTheMethods.service.AchievementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/achievements")
public class AchievementController {
    private final AchievementService achievementService;
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AchievementResponse> createAchievement(@Valid @RequestBody CreateAchievementRequest achievementDto){
        AchievementResponse savedAchievement = achievementService.createAchievement(achievementDto);
        return new ResponseEntity<>(savedAchievement, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AchievementResponse> getAchievementById(@PathVariable("id") Long id){
        AchievementResponse achievementDto = achievementService.getAchievementById(id);
        return ResponseEntity.ok(achievementDto);
    }

    @GetMapping
    public ResponseEntity<List<AchievementResponse>> getAllAchievements(){
        List<AchievementResponse> achievevments = achievementService.getAllAchievements();
        return ResponseEntity.ok(achievevments);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AchievementResponse> updateAchievement(@Valid @PathVariable("id") Long id, @Valid @RequestBody UpdateAchievementRequest updateAchievementDto){
        System.out.println(updateAchievementDto);
        AchievementResponse achievementDto = achievementService.updateAchievement(id, updateAchievementDto);
        return ResponseEntity.ok(achievementDto);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteAchievement(@PathVariable("id") Long id){
        achievementService.deleteAchievement(id);
        return ResponseEntity.ok("Deleted problem");
    }

    @GetMapping("categories/{category}")
    public ResponseEntity<List<AchievementResponse>> getAchievementsByCategory(@PathVariable("category") String category){
        List<AchievementResponse> achievementDtos = achievementService.getAchievementByCategory(category);
        return ResponseEntity.ok(achievementDtos);
    }

    @GetMapping("ranks/{rank}")
    public ResponseEntity<List<AchievementResponse>> getAchievementsByRank(@PathVariable("rank") String rank){
        List<AchievementResponse> achievementDtos = achievementService.getAchievementByRank(rank);
        return ResponseEntity.ok(achievementDtos);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AchievementResponse>> getAchievementsByCategoryAndRank(@RequestParam(required = false) List<String> categories, @RequestParam(required = false) List<String> ranks){
        List<AchievementResponse> achievementDtos = achievementService.getAchievementByCategoryAndRanks(categories,ranks);
        return ResponseEntity.ok(achievementDtos);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getAllAchievementsCount(){
        long countOfAchievements = achievementService.countAllTheAchievements();
        return ResponseEntity.ok(countOfAchievements);
    }


}
