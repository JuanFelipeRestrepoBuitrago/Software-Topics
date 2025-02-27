package com.eafit.tutorial09a.controllers;

import com.eafit.tutorial09a.models.Comment;
import com.eafit.tutorial09a.models.Product;
import com.eafit.tutorial09a.repositories.CommentRepository;
import com.eafit.tutorial09a.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products/{id}/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public String saveComment(@PathVariable Long id, Comment comment) {
        // Validaciones mínimas
        if (comment.getDescription() == null || comment.getDescription().isEmpty()) {
            throw new RuntimeException("Description is required");
        }
        // Get the product with the given id
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));

        // Add the comment to the product
        comment.setProduct(product);

        // Save the comment
        commentRepository.save(comment);

        return "redirect:/products/" + id;
    }
}
