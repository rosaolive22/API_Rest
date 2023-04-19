/*

package com.api.APIRest.controllers;


import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    //Simula requisições--> ENVIADO PR O FORUM
    @Autowired
    private MockMvc mvc;
 @Test
    @DisplayName("Devolve código http 400, resultados de informações inválidas.")
    //Consegue simular um user logado passando pela segurança, contrario devolve 403, retirando esta anotação é teste de segurança(devolve403).
    @WithMockUser
        //@WithMockUser(username="usuario", password = "password", authorities = {"1234"}, roles={"USER"})
    void cadastrar_cenario1() throws Exception {
        var response = mvc.perform(post("/product"))//dispara requisição sem corpo
                .andReturn().getResponse();//pega o resultado armazena na var response


        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());//e verifa o retono esperado

 }

    @Test
    @DisplayName("Retorno código 400, informações faltantes.")
    @WithMockUser //ignorar autenticação
    void cadastrar_cenari01() throws Exception {
        var response = mvc.perform(post("/product")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}




*/
