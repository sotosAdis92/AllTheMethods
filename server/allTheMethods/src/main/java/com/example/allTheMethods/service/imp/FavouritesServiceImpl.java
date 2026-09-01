package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.entity.Favourites;
import com.example.allTheMethods.mapper.FavouritesMapper;
import com.example.allTheMethods.repository.FavouritesRepository;
import com.example.allTheMethods.service.FavouritesService;
import org.springframework.stereotype.Service;

@Service
public class FavouritesServiceImpl implements FavouritesService {
    private FavouritesRepository favouritesRepository;
    private FavouritesMapper favouritesMapper;

    public FavouritesServiceImpl(FavouritesRepository favouritesRepository, FavouritesMapper favouritesMapper) {
        this.favouritesRepository = favouritesRepository;
        this.favouritesMapper = favouritesMapper;
    }

    @Override
    public FavouritesResponseDto createFavourite(CreateFavouriteRequestDto createFavouriteRequestDto) {
        Favourites favourite = favouritesMapper.toEntity(createFavouriteRequestDto);
        return favouritesMapper.toDto(favouritesRepository.save(favourite));
    }

    @Override
    public void deleteFavourite(Long id) {
        favouritesRepository.deleteById(id);
    }
}
