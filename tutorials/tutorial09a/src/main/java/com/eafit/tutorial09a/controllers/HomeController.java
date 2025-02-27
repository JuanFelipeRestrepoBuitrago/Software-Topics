package com.eafit.tutorial09a.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "/", "/home", "/index" })
    public String index(Model model) {
        model.addAttribute("title", "Home - Online Store");
        model.addAttribute("subtitle", "Welcome to Online Store Home");

        return "home/index";
    }
}
