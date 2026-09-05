package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.entity.Favourites;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.FavouritesMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FavouritesMapperImpl implements FavouritesMapper {
    @Override
    public Favourites toEntity(CreateFavouriteRequestDto createFavouriteRequestDto) {
        Favourites favourites = new Favourites();
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
    public FavouritesResponseDto toDto(Favourites favourites) {
        return new FavouritesResponseDto(
            favourites.getId(),
                favourites.getUser().getId(),
                favourites.getProblem().getId(),
                favourites.getDateAdded(),
                favourites.getProblem().getTitle(),
                favourites.getProblem().getNumber(),
                favourites.getProblem().getDifficulty(),
                favourites.getProblem().getCategory()
        );
    }

    @Override
    public List<FavouritesResponseDto> toDto(List<Favourites> favouritesList) {
        return favouritesList.stream().map(this::toDto).toList();
    }
}
