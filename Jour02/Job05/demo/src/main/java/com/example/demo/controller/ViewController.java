package com.example.demo.controller;

import com.example.demo.model.UserForm;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @GetMapping("/form")
    public String afficherForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "view";
    }

    // @Valid déclenche la validation de l'objet.
    // @ModelAttribute associe les données reçues à l'objet UserForm.
    // BindingResult récupère les erreurs de validation.
    @PostMapping("/form")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) {
        
        // Vérifie s'il y a des erreurs de validation
        if (bindingResult.hasErrors()) {
            return "view";
        }
        model.addAttribute("prenom", userForm.getPrenom());
        return "view";
    }
    
    
}
