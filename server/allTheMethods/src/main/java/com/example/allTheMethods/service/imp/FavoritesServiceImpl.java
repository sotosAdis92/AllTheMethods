package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.CreateFavoriteRequestDto;
import com.example.allTheMethods.dto.response.FavoritesResponseDto;
import com.example.allTheMethods.entity.Favorites;
import com.example.allTheMethods.mapper.FavoritesMapper;
import com.example.allTheMethods.repository.FavoritesRepository;
import com.example.allTheMethods.service.FavoritesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    private FavoritesRepository favoritesRepository;
    private FavoritesMapper favoritesMapper;

    public FavoritesServiceImpl(FavoritesRepository favoritesRepository, FavoritesMapper favoritesMapper) {
        this.favoritesRepository = favoritesRepository;
        this.favoritesMapper = favoritesMapper;
    }

    @Override
    public FavoritesResponseDto createFavourite(CreateFavoriteRequestDto createFavoriteRequestDto) {
        Favorites favourite = favoritesMapper.toEntity(createFavoriteRequestDto);
        return favoritesMapper.toDto(favoritesRepository.save(favourite));
    }

    @Override
    public void deleteFavourite(Long id) {
        favoritesRepository.deleteById(id);
    }

    @Override
    public Page<FavoritesResponseDto> getAllUserFavourites(int id, Pageable pageable) {
        Page<Favorites> allFavouritesOfUser = favoritesRepository.getFavouritesByUserId(id, pageable);
        return favoritesMapper.toDto(allFavouritesOfUser);
    }

    @Override
    public List<FavoritesResponseDto> getAllFavourites() {
        List<Favorites> allFavourites = favoritesRepository.findAll();
        return favoritesMapper.toDto(allFavourites);
    }
}
