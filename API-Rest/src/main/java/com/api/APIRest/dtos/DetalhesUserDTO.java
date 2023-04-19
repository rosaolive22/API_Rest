package com.api.APIRest.dtos;

import com.api.APIRest.enuns.EnunUsuarios;
import com.api.APIRest.models.Product;
import com.api.APIRest.models.Usuario;

import java.time.LocalDate;


public record DetalhesUserDTO(Long id,String name, String login, LocalDate date_register, EnunUsuarios roles) {
    public DetalhesUserDTO(Usuario usuario) {
            this(usuario.getId(),
                    usuario.getName(),
                    usuario.getLogin(),
                    usuario.getDate_register(),
                    usuario.getRoles());
        }
    }

