package com.example.demo.service;

import com.example.demo.repository.PersonRepository;
import com.example.demo.model.Person;
import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class PersonService {

    private final PersonRepository personRepository;

    // Injection par constructeur
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

}
