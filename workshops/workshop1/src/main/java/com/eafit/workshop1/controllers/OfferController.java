package com.eafit.workshop1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import com.eafit.workshop1.dto.OfferForm;
import com.eafit.workshop1.services.OfferService;

/**
 * OfferController is a Spring Boot Controller class that handles the requests
 * for the offers.
 * 
 * @author Juan Felipe Restrepo Buitrago
 */
@Controller
@RequestMapping("/offers")
public class OfferController {

    /**
     * Offer Service which provides the core business logic for the offers.
     */
    private final OfferService offerService;

    /**
     * Constructor for the OfferController class.
     * @param offerService The offer service to inject
     */
    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    
    /**
     * This method handles the requests for the offers creation page.
     * @param model The model object to pass data to the
     * @return The name of the view to render
     */
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("title", "Create Offer - Herzon");
        model.addAttribute("offerForm", new OfferForm());

        return "offers/create";
    }

    /**
     * This method handles the requests for the create offer form submission
     * @param offerForm The form data to create the offer
     * @param result The validation result
     * @param model The model object to pass data to the
     * 
     * @return The name of the view to render
     */
    @PostMapping("/create")
    public String createFormSubmission(@Valid @ModelAttribute("offerForm") OfferForm offerForm, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Create Offer - Herzon");
            
            return "offers/create";
        }

        try {
            // Call the method that might throw IllegalArgumentException
            offerService.createOffer(offerForm.getOfferPrice(), offerForm.getAuction());
        } catch (IllegalArgumentException ex) {
            // Add the exception message as a global error in BindingResult
            result.reject("", ex.getMessage());
            model.addAttribute("title", "Create Offer - Herzon");
            return "offers/create";
        }

        redirectAttributes.addFlashAttribute("messageSuccess", true);
        return "redirect:/offers";
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Offers - Herzon");
        model.addAttribute("offers", offerService.getAllOffers());
        
        return "offers/index";
    }
    
}
