package com.dev.testJewelryAuction.controllers;

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
}
