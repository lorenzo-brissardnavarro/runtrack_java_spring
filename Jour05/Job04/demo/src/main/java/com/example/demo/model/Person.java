package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @NotBlank(message = "Le prénom est obligatoire")
    @Size(min = 2, max = 30, message = "Le prénom doit contenir entre 2 et 30 caractères")
    private String name;

    @Min(value = 1, message = "Vous devez avoir au moins 1 an")
    @Max(value = 120, message = "Vous ne pouvez pas avoir plus de 120 ans")
    @NotNull(message = "Vous devez renseigner votre âge")
    private int age;

    // Constructeur vide
    public Person() {
    }

    // Constructeur avec parametre
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() { 
        return name; 
    }

    public int getAge() { 
        return age; 
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public void setAge(int age) { 
        this.age = age;
    }
}
