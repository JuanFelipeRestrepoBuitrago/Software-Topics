package com.eafit.tutorial13.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductDto {
    @NotBlank
    @Size(min = 1, max = 30)
    private Long id;

    @NotBlank
    private String name;
    
    @NotBlank
    @Size(min = 1, max = 1000)
    private Double price;

    public ProductDto() {}

    public ProductDto(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
