package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.service.FavouritesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFromFavourites(@PathVariable("id") Long id){
        favouritesService.deleteFavourite(id);
        return ResponseEntity.ok("Removed from Favourites");
    }

    @GetMapping("/all")
    public ResponseEntity<List<FavouritesResponseDto>> getAllFavourites(){
        List<FavouritesResponseDto> favouritesResponseDtos = favouritesService.getAllFavourites();
        return new ResponseEntity<>(favouritesResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/user/all/{id}")
    public ResponseEntity<List<FavouritesResponseDto>> getAllUserFavourites(@PathVariable int id){
        List<FavouritesResponseDto> favouritesOfUser = favouritesService.getAllUserFavourites(id);
        return new ResponseEntity<>(favouritesOfUser, HttpStatus.OK);
    }
}
