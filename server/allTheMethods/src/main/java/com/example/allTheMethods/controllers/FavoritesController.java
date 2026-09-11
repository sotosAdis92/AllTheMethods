package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.CreateFavoriteRequestDto;
import com.example.allTheMethods.dto.response.FavoritesResponseDto;
import com.example.allTheMethods.service.FavoritesService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/favourites")
public class FavoritesController {
    private FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @PostMapping
    public ResponseEntity<FavoritesResponseDto> addToFavorites(@Valid @RequestBody CreateFavoriteRequestDto createFavoriteRequestDto){
        FavoritesResponseDto favoritesResponseDto = favoritesService.createFavourite(createFavoriteRequestDto);
        return new ResponseEntity<>(favoritesResponseDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFromFavorites(@PathVariable("id") Long id){
        favoritesService.deleteFavourite(id);
        return ResponseEntity.ok("Removed from Favourites");
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<FavoritesResponseDto>> getAllFavorites(){
        List<FavoritesResponseDto> favoritesResponseDtos = favoritesService.getAllFavourites();
        return new ResponseEntity<>(favoritesResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/user/all/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<Page<FavoritesResponseDto>> getAllUserFavorites(
            @PathVariable("id") int id,
            @RequestParam(defaultValue = "1",name = "pageNo", required = false) int pageNo,
            @RequestParam(defaultValue = "20",name = "pageSize",required = false) int pageSize
    ){
        Page<FavoritesResponseDto> favouritesOfUser = favoritesService.getAllUserFavourites(id, PageRequest.of(pageNo-1, pageSize));
        return new ResponseEntity<>(favouritesOfUser, HttpStatus.OK);
    }
}
