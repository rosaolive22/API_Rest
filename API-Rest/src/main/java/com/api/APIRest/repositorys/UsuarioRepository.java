package com.api.APIRest.repositorys;

import com.api.APIRest.models.Product;
import com.api.APIRest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByLogin(String login);


    //List<Product> findByIdIn(List<Long> productIds);
}
