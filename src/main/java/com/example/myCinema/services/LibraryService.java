package com.example.myCinema.services;

import org.springframework.stereotype.Service;

import com.example.myCinema.repos.LibraryRepository;

@Service
public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }
}
