package com.example.demo.service;

import java.util.List;
import com.example.demo.repository.CommentRepository;

import org.springframework.stereotype.Service;
import com.example.demo.model.Comment;

@Service 
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
}

