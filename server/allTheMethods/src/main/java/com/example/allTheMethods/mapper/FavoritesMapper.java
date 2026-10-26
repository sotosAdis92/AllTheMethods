package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateFavoriteRequest;
import com.example.allTheMethods.dto.response.FavoritesResponse;
import com.example.allTheMethods.entity.Favorites;
import org.springframework.data.domain.Page;
import java.util.List;

public interface FavoritesMapper {
    Favorites toEntity(CreateFavoriteRequest createFavoriteRequest);
    FavoritesResponse toDto(Favorites favourites);
    List<FavoritesResponse> toDto(List<Favorites> favouritesList);
    Page<FavoritesResponse> toDto(Page<Favorites> favouritesPage);
}
