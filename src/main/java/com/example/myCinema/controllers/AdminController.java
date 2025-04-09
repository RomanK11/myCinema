package com.example.myCinema.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myCinema.services.AdminService;

@RestController
@RequestMapping(path = "/api/admin", produces = "application/json")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
}
