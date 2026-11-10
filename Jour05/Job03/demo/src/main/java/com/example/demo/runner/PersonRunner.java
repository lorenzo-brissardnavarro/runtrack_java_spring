package com.example.demo.runner;

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
        personRepository.save(new Person("Florian", 24));
        personRepository.save(new Person("Camille", 28));
    }
}
