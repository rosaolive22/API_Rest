package com.api.APIRest.dtos;

import com.api.APIRest.enuns.Category;
import com.api.APIRest.enuns.Culture;
import com.api.APIRest.enuns.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
        @NotBlank(message = "Name é obrigatório e único.")
        @Column(name = "name",unique = true)
        String name,
        @NotNull(message = "Price notnull")
        @Column(name = "name",unique = true)
        Float price,
        @NotBlank(message = "Description notnull")
        String description,
        //@NotBlank(message = "Culture notnull")
        Culture culture,
        //@NotBlank(message = "Category notnull")
        Category category,
        //@NotBlank(message = "Status notnull")
        Status status) {

}
