package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.Favourites;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavouritesRepository extends JpaRepository<Favourites, Long> {
    @Query("SELECT f FROM Favourites f WHERE f.user.id = ?1")
    Page<Favourites> getFavouritesByUserId(int id, Pageable pageable);
}
