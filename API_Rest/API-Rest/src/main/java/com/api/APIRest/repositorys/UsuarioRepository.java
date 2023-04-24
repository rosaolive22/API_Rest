package com.api.APIRest.repositorys;

import com.api.APIRest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    UserDetails findByLogin(String login);
}
