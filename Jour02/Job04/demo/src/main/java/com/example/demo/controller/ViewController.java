package com.example.demo.controller;

import com.example.demo.model.Produit; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ViewController {

    @GetMapping("/view")
    public String afficherMessage() {
        return "view";
    }


    @PostMapping("/form")
    public String recupInfos(@RequestParam("prenom") String prenom, Model model) {
        
        model.addAttribute("prenom", prenom);
        return "view";
    }
    
    
}
