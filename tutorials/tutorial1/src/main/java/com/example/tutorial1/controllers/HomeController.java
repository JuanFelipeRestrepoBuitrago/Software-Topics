package com.example.tutorial1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Welcome to Tutorial 1 Home");
        model.addAttribute("subtitle", "An Spring Boot Eafit App for Tutorial 1 at Software Engineering Special Topics");
        
        return "home/index";
    }
    
}
