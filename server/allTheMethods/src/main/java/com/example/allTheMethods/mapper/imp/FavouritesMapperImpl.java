package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.entity.Favourites;
import com.example.allTheMethods.mapper.FavouritesMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FavouritesMapperImpl implements FavouritesMapper {
    @Override
    public Favourites toEntity(CreateFavouriteRequestDto createFavouriteRequestDto) {
        return null;
    }

    @Override
    public FavouritesResponseDto toDto(Favourites favourites) {
        return null;
    }

    @Override
    public List<FavouritesResponseDto> toDto(List<Favourites> favouritesList) {
        return List.of();
    }
}
