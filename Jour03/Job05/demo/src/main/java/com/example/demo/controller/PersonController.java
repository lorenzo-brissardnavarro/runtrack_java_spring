package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.PersonRepository;


@Controller 
public class PersonController {
    
    private final PersonRepository personRepository;

    // Injection par constructeur
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/all")
    public String displayAll(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "all";
    }
    
}
