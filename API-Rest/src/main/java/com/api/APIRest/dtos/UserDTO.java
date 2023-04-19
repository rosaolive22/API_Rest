package com.api.APIRest.dtos;
//tratamentos de erros(2 links):
//https://cursos.alura.com.br/course/spring-boot-aplique-boas-praticas-proteja-api-rest/task/117181
//https://cursos.alura.com.br/forum/topico-endereco-274460
import com.api.APIRest.enuns.EnunUsuarios;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record UserDTO(
        Long id,
        //@NotBlank(message = "Name é obrigatório")
        String name,
        //@NotBlank(message = "Email é obrigatório")
        String login,
        //@NotBlank(message = "Password é obrigatório")
        //@Pattern(regexp = "\\d{6}")
        String password,
        LocalDate date_register,
        EnunUsuarios roles){

    }

