package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String name;
    private int age;

    // Constructeur vide
    public Person() {
    }

    // Constructeur avec parametre
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // on redéfinit la méthode pour pouvoir afficher correctement les infos de Person
    @Override
    public String toString() {
        return String.format("Person[id=%d, name='%s', age='%d']", id, name, age);
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
