package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Favorites;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    @Query("SELECT f FROM Favorites f WHERE f.user.id = ?1")
    Page<Favorites> getFavouritesByUserId(int id, Pageable pageable);
}
