package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.entity.Favourites;
import java.util.List;

public interface FavouritesMapper {
    Favourites toEntity(CreateFavouriteRequestDto createFavouriteRequestDto);
    FavouritesResponseDto toDto(Favourites favourites);
    List<FavouritesResponseDto> toDto(List<Favourites> favouritesList);
}
