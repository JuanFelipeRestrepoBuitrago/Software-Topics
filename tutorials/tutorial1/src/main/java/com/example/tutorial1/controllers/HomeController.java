package com.example.tutorial1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "/", "/home", "/index" })
    public String index(Model model) {
        model.addAttribute("title", "Home - Online Store Tutorial 1");
        model.addAttribute("subtitle", "Welcome to Tutorial 1 Home");

        return "home/index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About Us - Online Store Tutorial 1");
        model.addAttribute("subtitle", "About Us");
        model.addAttribute("description", "This is an about page, which is located at /about ...");
        model.addAttribute("author", "Developed by: Juan Felipe Restrepo Buitrago");

        return "home/about";
    }

}
