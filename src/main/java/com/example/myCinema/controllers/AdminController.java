package com.example.myCinema.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myCinema.models.Category;
import com.example.myCinema.models.Film;
import com.example.myCinema.models.User;
import com.example.myCinema.services.AdminService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(path = "/api/admin", produces = "application/json")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Пользователи
    @GetMapping("/users/get-user-by-name/{username}")
    public User getUser(@PathVariable("username") String username) {
        return adminService.getUserByName(username);
    }

    @DeleteMapping("/users/delete-user/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable String username) {
        adminService.delUser(username);
    }

    // Категории
    @PostMapping("/categories/add-category")
    public Category addCategory(@RequestBody Category category) {
        return adminService.addNewCategory(category);
    }

    @PatchMapping("/categories/update-category/{id}")
    public Category updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        return adminService.patchCategory(id, category);
    }

    @DeleteMapping("/categories/delete-category/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCategory(@PathVariable String name) {
        adminService.delCategory(name);
    }

    //Фильмы
    @PostMapping("/films/add-film")
    public Film addFilm(@RequestBody Film film) {
        return adminService.addNewFilm(film);
    }

    @PatchMapping("/films/update-film/{id}")
    public Film updateFilm(@PathVariable("id") Long id, @RequestBody Film film) {
        return adminService.patchFilm(id, film);
    }  
    
    @DeleteMapping("/films/delete-film/{title}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteFilm(@PathVariable("title") String title) {
        adminService.delFilmByTitle(title);
    }

}
