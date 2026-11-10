package com.example.demo.controller;

import com.example.demo.model.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.service.AppUserService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller 
public class PersonController {
    
    private final AppUserService appUserService;

    // Injection par constructeur
    public PersonController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/register"; // redirige vers la page de connexion
    }

    // Méthode pour afficher la page de connexion
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Méthode pour afficher la page d'inscription
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // Méthode pour gérer l'inscription d'un nouvel utilisateur
    @PostMapping("/register")
    public String registerUser(@ModelAttribute AppUser user) {
        appUserService.registerUser(user.getUsername(), user.getPassword());
        return "redirect:/login";
    }
    
    @GetMapping("/all")
    public String all() {
        return "all";
    }

}
