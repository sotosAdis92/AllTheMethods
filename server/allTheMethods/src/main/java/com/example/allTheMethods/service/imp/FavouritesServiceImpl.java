package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.CreateFavoriteRequestDto;
import com.example.allTheMethods.dto.response.FavoritesResponseDto;
import com.example.allTheMethods.entity.Favorites;
import com.example.allTheMethods.mapper.FavouritesMapper;
import com.example.allTheMethods.repository.FavouritesRepository;
import com.example.allTheMethods.service.FavouritesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouritesServiceImpl implements FavouritesService {
    private FavouritesRepository favouritesRepository;
    private FavouritesMapper favouritesMapper;

    public FavouritesServiceImpl(FavouritesRepository favouritesRepository, FavouritesMapper favouritesMapper) {
        this.favouritesRepository = favouritesRepository;
        this.favouritesMapper = favouritesMapper;
    }

    @Override
    public FavoritesResponseDto createFavourite(CreateFavoriteRequestDto createFavoriteRequestDto) {
        Favorites favourite = favouritesMapper.toEntity(createFavoriteRequestDto);
        return favouritesMapper.toDto(favouritesRepository.save(favourite));
    }

    @Override
    public void deleteFavourite(Long id) {
        favouritesRepository.deleteById(id);
    }

    @Override
    public Page<FavoritesResponseDto> getAllUserFavourites(int id, Pageable pageable) {
        Page<Favorites> allFavouritesOfUser = favouritesRepository.getFavouritesByUserId(id, pageable);
        return favouritesMapper.toDto(allFavouritesOfUser);
    }

    @Override
    public List<FavoritesResponseDto> getAllFavourites() {
        List<Favorites> allFavourites = favouritesRepository.findAll();
        return favouritesMapper.toDto(allFavourites);
    }
}
