package com.example.demo.runner;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

@Component 
public class CommentRunner implements CommandLineRunner {

    private final CommentRepository commentRepository;

    public CommentRunner(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... args) {
        // Ajout commentaires BDD
        commentRepository.save(new Comment("Aicha", "J'adore la Plateforme !"));
        commentRepository.save(new Comment("Thierry", "Vive le pingouin Linux !"));
        commentRepository.save(new Comment("Florian", "En pleine forme à la Plateforme !"));
    }
    
}
