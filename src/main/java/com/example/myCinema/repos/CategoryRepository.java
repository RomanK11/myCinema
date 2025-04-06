package com.example.myCinema.repos;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myCinema.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Query("SELECT id FROM categories WHERE name = :name")
    Long getIdByName(@Param("name") String name);
}
