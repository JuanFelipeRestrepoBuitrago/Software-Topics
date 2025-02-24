package com.eafit.workshop1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("title", "Create Offer - Herzon");

        return "offers/create";
    }

    
}
