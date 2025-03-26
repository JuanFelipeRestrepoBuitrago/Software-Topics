package com.eafit.tutorial12.controllers.rest;

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

import com.eafit.tutorial12.dto.ProductCollection;
import com.eafit.tutorial12.dto.ProductDto;
import com.eafit.tutorial12.models.Product;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin(origins = "*")
@Tag(name = "Product API v3", description = "Version 3 of the Product API, supporting metadata and pagination.")
public class ProductRestControllerV3 {

    // Simulated product data
    private List<Product> products = List.of(
            new Product(1L, "Product A", 10.0),
            new Product(2L, "Product B", 20.0),
            new Product(3L, "Product C", 30.0),
            new Product(4L, "Product D", 40.0),
            new Product(5L, "Product E", 50.0),
            new Product(6L, "Product F", 60.0)
    );

    /**
     * Retrieves all available products, including additional metadata about the store.
     *
     * @return A response containing the list of products and metadata.
     */
    @Operation(
        summary = "Retrieve all products with metadata",
        description = "Fetches a list of all available products and provides additional metadata, such as store name and API reference URL.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the product list",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ProductCollection.class)))
        }
    )
    @GetMapping("/products")
    public ResponseEntity<ProductCollection> index() {
        List<ProductDto> dtos = products.stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice()))
                .collect(Collectors.toList());

        ProductCollection collection = new ProductCollection(
                dtos,
                new ProductCollection.AdditionalData("Mega Store", "http://localhost:8080/api/v3/products")
        );

        return ResponseEntity.ok(collection);
    }

    /**
     * Retrieves a paginated list of products.
     *
     * @param page The page number to retrieve (default is 1).
     * @return A paginated list of products.
     */
    @Operation(
        summary = "Retrieve a paginated list of products",
        description = "Fetches products in a paginated format. Each page contains up to 5 products.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the paginated product list",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ProductCollection.class))),
            @ApiResponse(responseCode = "400", description = "Invalid page number")
        }
    )
    @GetMapping("/products/paginate")
    public ResponseEntity<ProductCollection> paginate(
        @Parameter(description = "Page number for pagination (default is 1)", example = "1")
        @RequestParam(defaultValue = "1") int page) {

        int pageSize = 5;
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, products.size());

        List<ProductDto> dtos;

        if (start >= products.size()) {
            dtos = List.of();
        } else {
            dtos = products.subList(start, end).stream()
                    .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice()))
                    .collect(Collectors.toList());
        }

        ProductCollection collection = new ProductCollection(
                dtos,
                new ProductCollection.AdditionalData("Mega Store", "http://localhost:8080/api/v3/products")
        );

        return ResponseEntity.ok(collection);
    }
}
