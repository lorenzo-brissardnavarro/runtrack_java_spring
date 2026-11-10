package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller 
public class PersonController {

    @GetMapping("/")
    public String home() {
        return "home"; 
    }
    
    @GetMapping("/home")
    public String accueil() {
        return "home";
    }

}
