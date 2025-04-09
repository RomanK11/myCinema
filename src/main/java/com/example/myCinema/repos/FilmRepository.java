package com.example.myCinema.repos;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myCinema.models.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {
    
    @Query("SELECT * FROM films WHERE category_id = :category_id")
    Iterable<Film> getAllByCategoryId(@Param("category_id") Long category_id);

    @Query("SELECT id FROM films WHERE :title = title")
    Long getIdByTitle(@Param("title") String title);
}
