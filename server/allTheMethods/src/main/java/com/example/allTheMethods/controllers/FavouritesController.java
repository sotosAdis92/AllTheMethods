package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.service.FavouritesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/favourites")
public class FavouritesController {
    private FavouritesService favouritesService;

    public FavouritesController(FavouritesService favouritesService) {
        this.favouritesService = favouritesService;
    }

    @PostMapping
    public ResponseEntity<FavouritesResponseDto> addToFavourites(@RequestBody CreateFavouriteRequestDto createFavouriteRequestDto){
        FavouritesResponseDto favouritesResponseDto = favouritesService.createFavourite(createFavouriteRequestDto);
        return new ResponseEntity<>(favouritesResponseDto, HttpStatus.CREATED);
    }
}
