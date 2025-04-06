package com.example.myCinema.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myCinema.models.Category;
import com.example.myCinema.models.Film;
import com.example.myCinema.repos.FilmRepository;
import com.example.myCinema.services.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping(path = "/api/categories", produces = "application/json")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/category/{name}")
    public Iterable<Film> getAllInCategory(@PathVariable("name") String name) {
        return categoryService.getAllByCategoryName(name);
    }

    @PostMapping("/add-category")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addNewCategory(category);
    }

    @DeleteMapping("/delete-category/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCategory(@PathVariable String name) {
        categoryService.delCategory(name);
    }
    
    
}
