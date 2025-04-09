package com.example.myCinema.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.myCinema.models.Category;
import com.example.myCinema.models.Film;
import com.example.myCinema.models.User;
import com.example.myCinema.repos.CategoryRepository;
import com.example.myCinema.repos.FilmRepository;
import com.example.myCinema.repos.UserRepository;

@Service
public class AdminService {
    private CategoryRepository categoryRepository;
    private FilmRepository filmRepository;
    private UserRepository userRepository;

    public AdminService(CategoryRepository categoryRepository, FilmRepository filmRepository,  UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.filmRepository = filmRepository;
        this.userRepository = userRepository;
    }

    //Пользователи
    public User getUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    public void delUser(String username) {
        Long id = userRepository.findIdByName(username);
        userRepository.deleteById(id);
    }

    //Категории
    public Category addNewCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    public void delCategory(String name) {
        Long id = categoryRepository.getIdByName(name);
        categoryRepository.deleteById(id);
    }

    public Category patchCategory(Long id, @RequestBody Category categoryPatch) {
        Category category = categoryRepository.findById(id).get();
        if (category.getName() != null) {
            category.setName(categoryPatch.getName());
        }
        return categoryRepository.save(category);
    }

    //Фильмы
    public Film addNewFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    public Film patchFilm(Long id, @RequestBody Film filmPatch) {
        Film film = filmRepository.findById(id).get();
        if (film.getTitle() != null) {
            film.setTitle(filmPatch.getTitle());
        }
        if (film.getLink() != null) {
            film.setLink(filmPatch.getLink());
        }
        if (film.getCategory_id() != null) {
            film.setCategory_id(filmPatch.getCategory_id());
        }
        if (film.getRate() != null) {
            film.setRate(filmPatch.getRate());
        }

        return filmRepository.save(film);
    }

    public void delFilmByTitle(String title) {
        Long id = filmRepository.getIdByTitle(title);
        filmRepository.deleteById(id);
    }
}
