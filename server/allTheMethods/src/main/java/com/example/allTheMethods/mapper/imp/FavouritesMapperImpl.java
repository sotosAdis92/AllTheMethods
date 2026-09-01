package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.request.CreateFavouriteRequestDto;
import com.example.allTheMethods.dto.response.FavouritesResponseDto;
import com.example.allTheMethods.entity.Favourites;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.FavouritesMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FavouritesMapperImpl implements FavouritesMapper {
    @Override
    public Favourites toEntity(CreateFavouriteRequestDto createFavouriteRequestDto) {
        Users user = new Users();
        user.setId(createFavouriteRequestDto.userId());
        Problem problem = new Problem();
        problem.setId(createFavouriteRequestDto.problemId());
        Favourites favourite = new Favourites(
                null,
                user,
                problem,
                createFavouriteRequestDto.dateAdded()
        );
        return favourite;
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
