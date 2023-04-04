package com.api.APIRest.dtos;

import com.api.APIRest.enuns.Category;
import com.api.APIRest.enuns.Culture;
import com.api.APIRest.enuns.Status;
import jakarta.validation.constraints.NotBlank;

public record CatalogDTO(
        Culture culture,
        Category category,
        Status status,
        @NotBlank(message = "Linha notnull.")
         String linha) {
}
