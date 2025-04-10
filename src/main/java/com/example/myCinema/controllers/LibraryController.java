package com.example.myCinema.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myCinema.models.Film;
import com.example.myCinema.models.Library;
import com.example.myCinema.services.LibraryService;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "/api/libraries", produces = "application/json")
public class LibraryController {
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/all-library/{user_id}")
    public Iterable<Film> getAll(@PathVariable Long user_id) {
        return libraryService.getAllFilms(user_id);
    }

    @PostMapping("/add-film-to-library/{user_id}")
    public Library addFilmToLibrary(@PathVariable("user_id") Long user_id, @RequestBody Library library) {
        return libraryService.addFilm(user_id, library);
    }

    @DeleteMapping("/delete-film-from-library/{user_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteFilmFromLibrary(@PathVariable("user_id") Long user_id) {
        libraryService.delFilmFromLibrary(user_id);
    }
    
}
