package com.eafit.tutorial12.controllers.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eafit.tutorial12.models.Product;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    // List of products to simulate a database
    private List<Product> products = new ArrayList<>();

    public ProductRestController() {
        products.add(new Product(1L, "Product A", 100.0));
        products.add(new Product(2L, "Product B", 200.0));
        products.add(new Product(3L, "Product C", 300.0));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
