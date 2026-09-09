package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateFavoriteRequestDto;
import com.example.allTheMethods.dto.response.FavoritesResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FavouritesService {
    FavoritesResponseDto createFavourite(CreateFavoriteRequestDto createFavoriteRequestDto);
    void deleteFavourite(Long id);
    Page<FavoritesResponseDto> getAllUserFavourites(int id, Pageable pageable);
    List<FavoritesResponseDto> getAllFavourites();
}
