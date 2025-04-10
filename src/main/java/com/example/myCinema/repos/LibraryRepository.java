package com.example.myCinema.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.myCinema.models.Library;

public interface LibraryRepository extends CrudRepository<Library, Long>  {
    
}
