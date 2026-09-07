package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.service.FavouritesService;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<FavouritesResponseDto>> getAllFavourites(){
        List<FavouritesResponseDto> favouritesResponseDtos = favouritesService.getAllFavourites();
        return new ResponseEntity<>(favouritesResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/user/all/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<Page<FavouritesResponseDto>> getAllUserFavourites(
            @PathVariable("id") int id,
            @RequestParam(defaultValue = "1",name = "pageNo", required = false) int pageNo,
            @RequestParam(defaultValue = "20",name = "pageSize",required = false) int pageSize
    ){
        Page<FavouritesResponseDto> favouritesOfUser = favouritesService.getAllUserFavourites(id, PageRequest.of(pageNo-1, pageSize));
        return new ResponseEntity<>(favouritesOfUser, HttpStatus.OK);
    }
}
