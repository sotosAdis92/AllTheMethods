package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateFavoriteRequestDto;
import com.example.allTheMethods.dto.response.FavoritesResponseDto;
import com.example.allTheMethods.entity.Favorites;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FavoritesMapper {
    Favorites toEntity(CreateFavoriteRequestDto createFavoriteRequestDto);
    FavoritesResponseDto toDto(Favorites favourites);
    List<FavoritesResponseDto> toDto(List<Favorites> favouritesList);
    Page<FavoritesResponseDto> toDto(Page<Favorites> favouritesPage);
}
