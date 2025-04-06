package com.example.myCinema.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.myCinema.models.Category;
import com.example.myCinema.models.Film;
import com.example.myCinema.repos.CategoryRepository;
import com.example.myCinema.repos.FilmRepository;

@Service
public class CategoryService {
    private FilmRepository filmRepository;
    private CategoryRepository categoryRepository;

    public CategoryService(FilmRepository filmRepository, CategoryRepository categoryRepository) {
        this.filmRepository = filmRepository;
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Film> getAllByCategoryName(String name) {
        Long id = categoryRepository.getIdByName(name);
        return filmRepository.getAllByCategoryId(id);
    }

    public Category addNewCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    public void delCategory(String name) {
        Long id = categoryRepository.getIdByName(name);
        categoryRepository.deleteById(id);
    }

    
}
