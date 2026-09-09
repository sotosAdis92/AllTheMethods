package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.entity.Favorites;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.FavouritesMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FavouritesMapperImpl implements FavouritesMapper {
    @Override
    public Favorites toEntity(CreateFavouriteRequestDto createFavouriteRequestDto) {
        Favorites favourites = new Favorites();
        Users user = new Users();
        user.setId(createFavouriteRequestDto.user());
        favourites.setUser(user);
        Problem problem = new Problem();
        problem.setId(createFavouriteRequestDto.problem());
        favourites.setProblem(problem);
        favourites.setDateAdded(LocalDateTime.now());
        return favourites;
    }

    @Override
    public FavouritesResponseDto toDto(Favorites favorites) {
        return new FavouritesResponseDto(
            favorites.getId(),
                favorites.getUser().getId(),
                favorites.getProblem().getId(),
                favorites.getDateAdded(),
                favorites.getProblem().getTitle(),
                favorites.getProblem().getNumber(),
                favorites.getProblem().getDifficulty(),
                favorites.getProblem().getCategory()
        );
    }

    @Override
    public List<FavouritesResponseDto> toDto(List<Favorites> favoritesList) {
        return favoritesList.stream().map(this::toDto).toList();
    }

    @Override
    public Page<FavouritesResponseDto> toDto(Page<Favorites> favoritesPage) {
        return favoritesPage.map(this::toDto);
    }
}
