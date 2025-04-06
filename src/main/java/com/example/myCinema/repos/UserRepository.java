package com.example.myCinema.repos;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myCinema.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
   
    
}
