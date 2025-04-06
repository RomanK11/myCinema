package com.example.myCinema.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.myCinema.models.Film;
import com.example.myCinema.repos.CategoryRepository;
import com.example.myCinema.repos.FilmRepository;

@Service
public class FilmService {
    private FilmRepository filmRepository;
    private CategoryRepository categoryRepository;

    public FilmService(FilmRepository filmRepository, CategoryRepository categoryRepository) {
        this.filmRepository = filmRepository;
        this.categoryRepository = categoryRepository;
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }
}
