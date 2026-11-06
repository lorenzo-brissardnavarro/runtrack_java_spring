package com.example.demo.controller;

import com.example.demo.model.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class PersonController {
    
    private final PersonService personService;

    // Injection par constructeur
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Méthode pour afficher tous les objets Person
    @GetMapping("/all")
    public String displayAll(Model model) {
        model.addAttribute("persons", personService.findAll());
        model.addAttribute("person", new Person()); // nouvel objet vide pour le formulaire
        return "all";
    }

    // Méthode pour ajouter un nouvel objet Person ou mettre à jour un objet existant
    @PostMapping("/save")
    public String SavePerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/all";
    }

    // Méthode pour supprimer un objet Person
    @PostMapping("/delete")
    public String deletePerson(@RequestParam Long id) {
        personService.deleteById(id);
        return "redirect:/all";
    }

}
