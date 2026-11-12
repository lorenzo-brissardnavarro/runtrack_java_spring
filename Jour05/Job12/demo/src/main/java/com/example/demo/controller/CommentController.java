package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.CommentService;




@Controller 
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String home() {
        return "home"; 
    }
    
    @GetMapping("/home")
    public String accueil() {
        return "home";
    }

    @GetMapping("/comments")
    public String comments() {
        return "comments";
    }

    @GetMapping("/comments-refresh")
    public String RefreshComments(Model model) {
        model.addAttribute("comments", commentService.getComments());
        return "fragments/liste :: commentaires-asynchrones";
    }
    

}
