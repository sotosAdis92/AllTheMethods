package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FavouritesService {
    FavouritesResponseDto createFavourite(CreateFavouriteRequestDto createFavouriteRequestDto);
    void deleteFavourite(Long id);
    Page<FavouritesResponseDto> getAllUserFavourites(int id, Pageable pageable);
    List<FavouritesResponseDto> getAllFavourites();
}
