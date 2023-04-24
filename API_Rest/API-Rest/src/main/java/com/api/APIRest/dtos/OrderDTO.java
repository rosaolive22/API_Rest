package com.api.APIRest.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record OrderDTO(
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @NotNull(message = "Phone é obrigatório")
        String phone,
        @Email(message = "Formato do email é inválido")
        @NotBlank(message = "E-mail é obrigatório e único")
        String e_mail,
        String country){

}
