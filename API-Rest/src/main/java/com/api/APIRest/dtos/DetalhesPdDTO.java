package com.api.APIRest.dtos;

import com.api.APIRest.enuns.Category;
import com.api.APIRest.enuns.Culture;
import com.api.APIRest.enuns.Status;
import com.api.APIRest.models.Product;

public record DetalhesPdDTO(String nome, Float price, String description, Culture culture, Category category, Status status) {
    public DetalhesPdDTO(Product product) {
        this(product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCulture(),
                product.getCategory(),
                product.getStatus());
    }
}
