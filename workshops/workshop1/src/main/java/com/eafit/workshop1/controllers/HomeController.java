package com.eafit.workshop1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController is a Spring Boot Controller class that handles the requests
 * for the home page.
 * 
 * @author Juan Felipe Restrepo Buitrago
 */
@Controller
public class HomeController {

    /**
     * This method handles the requests for the home page.
     * @param model The model object to pass data to the
     * @return The name of the view to render
     */
    @GetMapping({ "/", "/home", "/index" })
    public String index(Model model) {
        model.addAttribute("title", "Home - Herzon");
        
        return "home/index";
    }
}
