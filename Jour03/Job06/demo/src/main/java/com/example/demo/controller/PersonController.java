package com.example.demo.controller;

import com.example.demo.model.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


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
        model.addAttribute("person", new Person()); // nouvel objet vide pour le formulaire
        return "all";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/all";
    }
    
    
}
