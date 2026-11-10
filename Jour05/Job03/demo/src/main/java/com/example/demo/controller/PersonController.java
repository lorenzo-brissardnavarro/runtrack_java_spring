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

    // Méthode pour afficher tous les objets Person
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("person", new Person()); // nouvel objet vide pour le formulaire
        return "persons";
    }

    // Méthode pour ajouter un nouvel objet Person
    @PostMapping("/save")
    public String SavePerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/";
    }

}
