package com.eafit.tutorial07.controllers;

import com.eafit.tutorial07.models.Product;
import com.eafit.tutorial07.models.Comment;
import com.eafit.tutorial07.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String index(Model model) {
        // Get all products from the database
        List<Product> products = productRepository.findAll();

        model.addAttribute("title", "Products - Online Store");
        model.addAttribute("subtitle", "List of products");
        model.addAttribute("products", products);

        return "product/index";
    }

    @GetMapping("/products/{id}")
    public String show(@PathVariable Long id, Model model) {
        // Get the product with the given id
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));

        model.addAttribute("title", product.getName() + " - Online Store");
        model.addAttribute("subtitle", product.getName() + " - Product details");
        model.addAttribute("product", product);
        model.addAttribute("comment", new Comment());

        return "product/show";
    }

    @GetMapping("/products/create")
    public String createProductForm(Model model) {
        model.addAttribute("product", new Product());

        return "product/create";
    }

    @PostMapping("/products")
    public String save(Product product) { 
        // Validaciones mínimas
        if (product.getName() == null || product.getName().isEmpty() || product.getPrice() == null) {
            throw new RuntimeException("Name and Price are required");
        }
        productRepository.save(product);
        return "redirect:/products";
    }


}
