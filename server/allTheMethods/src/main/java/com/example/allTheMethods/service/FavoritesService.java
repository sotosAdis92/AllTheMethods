package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateFavoriteRequest;
import com.example.allTheMethods.dto.response.FavoritesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface FavoritesService {
    FavoritesResponse createFavourite(CreateFavoriteRequest createFavoriteRequest);
    void deleteFavourite(Long id);
    Page<FavoritesResponse> getAllUserFavourites(int id, Pageable pageable);
    List<FavoritesResponse> getAllFavourites();
}
