package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateFavoriteRequest;
import com.example.allTheMethods.dto.response.FavoritesResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface FavoritesService {
    FavoritesResponseDto createFavourite(CreateFavoriteRequest createFavoriteRequest);
    void deleteFavourite(Long id);
    Page<FavoritesResponseDto> getAllUserFavourites(int id, Pageable pageable);
    List<FavoritesResponseDto> getAllFavourites();
}
