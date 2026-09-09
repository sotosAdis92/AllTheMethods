package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.entity.Favorites;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FavouritesMapper {
    Favorites toEntity(CreateFavouriteRequestDto createFavouriteRequestDto);
    FavouritesResponseDto toDto(Favorites favourites);
    List<FavouritesResponseDto> toDto(List<Favorites> favouritesList);
    Page<FavouritesResponseDto> toDto(Page<Favorites> favouritesPage);
}
