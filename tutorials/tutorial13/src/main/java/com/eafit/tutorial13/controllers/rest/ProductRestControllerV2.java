package com.eafit.tutorial13.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eafit.tutorial13.dto.ProductDto;
import com.eafit.tutorial13.models.Product;

@RestController
@RequestMapping("/api/v2")
@Tag(name = "Product API v2", description = "Version 2 of the Product API, using DTOs for better structure")
public class ProductRestControllerV2 {

    // Simulated database
    private List<Product> products = new ArrayList<>();

    public ProductRestControllerV2() {
        products.add(new Product(1L, "Product A", 100.0));
        products.add(new Product(2L, "Product B", 200.0));
        products.add(new Product(3L, "Product C", 300.0));
    }

    @Operation(
        summary = "Retrieve all products",
        description = "Returns a list of all available products in a DTO format.",
        responses = {
            @ApiResponse(responseCode = "200", description = "List of products retrieved successfully",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ProductDto.class)))
        }
    )
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> dtos = products.stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @Operation(
        summary = "Retrieve a product by ID",
        description = "Fetches a specific product by its unique identifier and returns it as a DTO.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Product found",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "404", description = "Product not found")
        }
    )
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProduct(
        @Parameter(description = "ID of the product to retrieve", required = true)
        @PathVariable Long id) {

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
