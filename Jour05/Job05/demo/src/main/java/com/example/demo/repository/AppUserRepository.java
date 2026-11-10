package com.example.demo.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    // Recherche par nom d'utilisateur
    Optional<AppUser> findByUsername(String username);
    
}
