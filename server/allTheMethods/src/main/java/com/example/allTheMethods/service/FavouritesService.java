package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;

public interface FavouritesService {
    FavouritesResponseDto createFavourite(CreateFavouriteRequestDto createFavouriteRequestDto);
    void deleteFavourite(Long id);
}
