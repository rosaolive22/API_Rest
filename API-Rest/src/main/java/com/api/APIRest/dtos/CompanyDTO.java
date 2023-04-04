package com.api.APIRest.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CompanyDTO(
    @NotNull
    @Pattern(regexp = "\\d{14}", message = "Cnpj inválido")
    String cnpj,
    @NotBlank(message = "Name é obrigatório e único.")
    @Column(name = "name",unique = true)
    String name,
    String business_branch,
    Integer founding_yeans) {
}
