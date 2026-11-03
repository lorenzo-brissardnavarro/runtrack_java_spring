package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String afficherMessage(Model model) {
        // Ajout d'une variable au modèle (transmise à la vue)
        model.addAttribute("message", "Ceci est un message affiché avec Thymeleaf.");
        // Retourne le nom du fichier template (sans l'extension .html)
        return "view";
    }
}
