package com.example.myCinema.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.myCinema.models.Category;
import com.example.myCinema.models.Film;
import com.example.myCinema.models.Library;
import com.example.myCinema.repos.FilmRepository;
import com.example.myCinema.repos.LibraryRepository;

@Service
public class LibraryService {
    private LibraryRepository libraryRepository;
    private FilmRepository filmRepository;

    public LibraryService(LibraryRepository libraryRepository, FilmRepository filmRepository) {
        this.libraryRepository = libraryRepository;
        this.filmRepository = filmRepository;
    }

    public Iterable<Film> getAllFilms(Long user_id) {
        Iterable<Long> films = libraryRepository.findFilmsByUserId(user_id);
        return filmRepository.findAllById(films);
    }

    public Library addFilm(Long id, @RequestBody Library library) {
        library.setUser_id(id);
        return libraryRepository.save(library);
    }

    public void delFilmFromLibrary(Long user_id) {
        Long id = libraryRepository.getIdByUserId(user_id);
        libraryRepository.deleteById(id);

    }
}
