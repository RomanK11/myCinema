package com.example.myCinema.repos;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myCinema.models.Library;

public interface LibraryRepository extends CrudRepository<Library, Long>  {
    @Query("SELECT film_id FROM libraries WHERE user_id = :user_id")
    Iterable<Long> findFilmsByUserId(@Param("user_id") Long user_id);

    @Query("SELECT film_id FROM libraries WHERE user_id = :user_id")
    Long getFilmId(@Param("user_id") Long user_id);

    @Query("SELECT id FROM libraries WHERE user_id = :user_id")
    Long getIdByUserId(@Param("user_id") Long user_id);
}
