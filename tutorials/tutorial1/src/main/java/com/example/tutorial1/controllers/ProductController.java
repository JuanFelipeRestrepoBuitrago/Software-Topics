package com.example.tutorial1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private static final List<Map<String, String>> products = new ArrayList(List.of(
            Map.of("id", "1", "name", "TV", "description", "Best TV", "price", "200"),
            Map.of("id", "2", "name", "iPhone", "description", "Best iPhone", "price", "250"),
            Map.of("id", "3", "name", "Chromecast", "description", "Best Chromecast", "price", "50"),
            Map.of("id", "4", "name", "Glasses", "description", "Best Glasses", "price", "99")));

    @GetMapping("/products")
    public String index(Model model) {
        model.addAttribute("title", "Products - Online Store Tutorial 1");
        model.addAttribute("subtitle", "List of Products");
        model.addAttribute("products", products);

        return "product/index";
    }

    @GetMapping("/products/{id}")
    public String show(@PathVariable String id, Model model) {

        int productId = Integer.parseInt(id) - 1;
        if (productId < 0 || productId >= products.size()) {
            return "redirect:/";
        }

        Map<String, String> productData = products.get(productId);
        Map<String, Object> product = Map.of(
                "id", productData.get("id"),
                "name", productData.get("name"),
                "description", productData.get("description"),
                "price", Integer.parseInt(productData.get("price")) // Convert to Integer
        );

        model.addAttribute("title", product.get("name") + " - Online Store Tutorial 1");
        model.addAttribute("subtitle", product.get("name") + " - Product Information");
        model.addAttribute("product", product);

        return "product/show";
    }

    @GetMapping("/products/create")
    public String create(Model model) {
        model.addAttribute("title", "Create Product");
        model.addAttribute("subtitle", "Create a new Product");
        model.addAttribute("productForm", new ProductForm());

        return "product/create";
    }

    @PostMapping("/products/save")
    public String save(@Valid @ModelAttribute("productForm") ProductForm productForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Create Product");
            return "product/create";
        }

        
        Map<String, String> product = new HashMap<>();
        product.put("id", String.valueOf(products.size() + 1));
        product.put("name", productForm.getName());
        product.put("description", productForm.getDescription());
        product.put("price", String.valueOf(productForm.getPrice()));

        products.add(product);

        return "redirect:/products";
    }

}
