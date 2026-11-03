package com.example.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserForm {
    @NotBlank(message = "Le prénom est obligatoire")
    @Size(min = 2, max = 30, message = "Le prénom doit contenir entre 2 et 30 caractères")
    private String prenom;
    
    @Min(value = 1, message = "Vous devez avoir au moins 1 an")
    @Max(value = 120, message = "Vous ne pouvez pas avoir plus de 120 ans")
    @NotNull(message = "Vous devez renseigner votre âge")
    private Integer age;

    public UserForm() {
    }

    public String getPrenom() { 
        return prenom; 
    }

    public Integer getAge() { 
        return age; 
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
