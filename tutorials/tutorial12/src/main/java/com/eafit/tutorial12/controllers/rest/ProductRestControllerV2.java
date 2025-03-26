package com.eafit.tutorial12.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eafit.tutorial12.dto.ProductDto;
import com.eafit.tutorial12.models.Product;

@RestController
@RequestMapping("/api/v2")
public class ProductRestControllerV2 {

    // List of products to simulate a database
    private List<Product> products = new ArrayList<>();

    public ProductRestControllerV2() {
        products.add(new Product(1L, "Product A", 100.0));
        products.add(new Product(2L, "Product B", 200.0));
        products.add(new Product(3L, "Product C", 300.0));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> dtos = products.stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        Product product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (product != null) {
            ProductDto dto = new ProductDto(product.getId(), product.getName(), product.getPrice());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
