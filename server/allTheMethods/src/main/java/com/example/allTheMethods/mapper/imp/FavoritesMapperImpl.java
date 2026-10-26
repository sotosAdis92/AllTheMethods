package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.request.CreateFavoriteRequest;
import com.example.allTheMethods.dto.response.FavoritesResponse;
import com.example.allTheMethods.entity.Favorites;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.FavoritesMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class FavoritesMapperImpl implements FavoritesMapper {
    @Override
    public Favorites toEntity(CreateFavoriteRequest createFavoriteRequest) {
        Favorites favourites = new Favorites();
        Users user = new Users();
        user.setId(createFavoriteRequest.user());
        favourites.setUser(user);
        Problem problem = new Problem();
        problem.setId(createFavoriteRequest.problem());
        favourites.setProblem(problem);
        favourites.setDateAdded(LocalDateTime.now());
        return favourites;
    }

    @Override
    public FavoritesResponse toDto(Favorites favorites) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date = favorites.getDateAdded().format(formatter);
        return new FavoritesResponse(
            favorites.getId(),
                favorites.getUser().getId(),
                favorites.getProblem().getId(),
                date,
                favorites.getProblem().getTitle(),
                favorites.getProblem().getNumber(),
                favorites.getProblem().getDifficulty(),
                favorites.getProblem().getCategory()
        );
    }

    @Override
    public List<FavoritesResponse> toDto(List<Favorites> favoritesList) {
        return favoritesList.stream().map(this::toDto).toList();
    }

    @Override
    public Page<FavoritesResponse> toDto(Page<Favorites> favoritesPage) {
        return favoritesPage.map(this::toDto);
    }
}
