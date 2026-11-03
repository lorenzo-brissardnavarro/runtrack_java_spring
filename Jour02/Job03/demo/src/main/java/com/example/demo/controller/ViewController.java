package com.example.demo.controller;

import com.example.demo.model.Produit; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ViewController {

    // Méthode 1 avec l'objet Model et model.attribute("clé", valeur)
    @GetMapping("/view")
    public String afficherProduits(Model model) {
        List<Produit> produits = List.of(
            new Produit("Ordinateur", 800),
            new Produit("Téléphone", 500)
        );
        model.addAttribute("produits", produits);
        return "view";
    }

    // Méthode 2 avec ModelMap et modelMap.addAttribute("clé", valeur)
    // @GetMapping("/view")
    // public String afficherProduits(ModelMap modelMap) {
    //     List<Produit> produits = List.of(
    //         new Produit("Ordinateur", 800),
    //         new Produit("Téléphone", 500)
    //     );
    //     modelMap.addAttribute("produits", produits);
    //     return "view";
    // }

    // Méthode 3 avec ModelAndView
    // @GetMapping("/view")
    // public ModelAndView afficherProduits() {
    //     List<Produit> listeProduits = List.of(
    //         new Produit("Ordinateur", 800),
    //         new Produit("Téléphone", 500)
    //     );
    //     ModelAndView mav = new ModelAndView("view"); // nom de la vue
    //     mav.addObject("produits", listeProduits);
    //     return mav;
    // }
    
    
}
