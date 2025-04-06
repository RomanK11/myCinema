package com.example.myCinema.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.myCinema.models.User;
import com.example.myCinema.repos.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   public User createUser(@RequestBody User user) {
        return userRepository.save(user);
   }
}
