package com.example.demo.runner;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Component 
public class PersonRunner implements CommandLineRunner{
    
    private final PersonRepository personRepository;

    // Injection par constructeur
    public PersonRunner(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override 
    public void run(String... args) {
        // on crée 2 personnes
        personRepository.save(new Person("Julie", 25));
        personRepository.save(new Person("Pierre", 38));

        // on récupère toutes les personnes dans BDD et on affiche
        List<Person> all = personRepository.findAll();
        System.out.println("Toutes les personnes " + all.toString());

        System.out.println("Personne en particulier : " + (personRepository.findByName("Julie").toString()));
        System.out.println("Personne qui a plus de 30 ans : " + (personRepository.findByAgeGreaterThan(30).toString()));
    }
}
