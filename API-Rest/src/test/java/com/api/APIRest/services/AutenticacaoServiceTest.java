package com.api.APIRest.services;

import com.api.APIRest.repositorys.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AutenticacaoServiceTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @Test
    @DisplayName("Retorno código 200, usuário logado.")
    void loadUserByUsername() {



/*
                // Crie o cenário necessário para o teste
                // Exemplo: crie um objeto que será utilizado como entrada do método
                ObjetoEntrada objetoEntrada = new ObjetoEntrada();

                // Execute o método que será testado
                ObjetoSaida objetoSaida = minhaClasseService.meuMetodo(objetoEntrada);

                // Verifique se o resultado é o esperado
                // Exemplo: verifique se o objeto de saída tem o valor correto em um campo específico
                assertThat(objetoSaida.getCampo()).isEqualTo("valor esperado");*/
    }
}

