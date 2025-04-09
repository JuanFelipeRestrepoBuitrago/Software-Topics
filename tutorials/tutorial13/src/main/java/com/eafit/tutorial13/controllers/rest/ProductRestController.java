package com.eafit.tutorial13.controllers.rest;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eafit.tutorial13.models.Product;

@RestController
@RequestMapping("/api")
@Tag(name = "Product API", description = "Operations related to managing products")
public class ProductRestController {

    // List of products to simulate a database
    private List<Product> products = new ArrayList<>();

    public ProductRestController() {
        products.add(new Product(1L, "Product A", 100.0));
        products.add(new Product(2L, "Product B", 200.0));
        products.add(new Product(3L, "Product C", 300.0));
    }

    @Operation(
        summary = "Retrieve all products",
        description = "Returns a list of all available products.",
        responses = {
            @ApiResponse(responseCode = "200", description = "List of products successfully retrieved",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = Product.class)))
        }
    )
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(products);
    }

    @Operation(
        summary = "Retrieve a product by ID",
        description = "Fetches a specific product by its unique identifier.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Product found",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "404", description = "Product not found")
        }
    )
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(
        @Parameter(description = "ID of the product to retrieve", required = true) 
        @PathVariable Long id) {

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

    @Operation(
        summary = "Create a new product",
        description = "Adds a new product to the list.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Product successfully created",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
        }
    )
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(
        @Parameter(description = "Product object to be created", required = true)
        @RequestBody Product product) {

        products.add(product);
        return ResponseEntity.ok(product);
    }
}
