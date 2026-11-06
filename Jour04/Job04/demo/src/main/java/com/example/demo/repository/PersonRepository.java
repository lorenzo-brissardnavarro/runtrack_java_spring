package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Person;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> { // Person correspond à l'entité que nous manipulons et Long correspond au type de la clé primaire de cette entité
    // Recherche par nom
    List<Person> findByName(String name);

    // Recherche par age minimum
    List<Person> findByAgeGreaterThan(int age);
}
