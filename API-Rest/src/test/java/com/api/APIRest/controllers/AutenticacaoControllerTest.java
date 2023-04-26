package com.api.APIRest.controllers;

import com.api.APIRest.infra.security.TokenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AutenticacaoControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    private final String LOGIN_ENDPOINT = "/login";
    private final String DADOS_TOKEN_ENDPOINT = "/dados-token";

    @Test
    @DisplayName("Retorno código 403, não autorizado.")
    void cadastrar_user() throws Exception {
        var response = mvc.perform(post("/cadastrar"))
            .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.FORBIDDEN.value());
    }


  /*  @Test
    void efetuarLoginTest() throws Exception {
        // Cria um usuário de teste e armazena suas credenciais em um objeto AutenticacaoDados
        AutenticacaoDados usuario = new AutenticacaoDados();
        usuario.setLogin("usuario_teste");
        usuario.setPassword("senha_teste");

        // Simula a autenticação do usuário enviando uma solicitação HTTP POST para a rota de login
        MvcResult result = mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andReturn();

        // Verifica se o token JWT é gerado corretamente a partir do usuário autenticado
        String token = objectMapper.readValue(result.getResponse().getContentAsString(), DadosTokenJWT.class).getToken();
        Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
        assertThat(claims.getSubject()).isEqualTo("usuario_teste");
    }*/



}




//------------------
/*@SpringBootTest
@AutoConfigureMockMvc
class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    private final String LOGIN_ENDPOINT = "/login";
    private final String DADOS_TOKEN_ENDPOINT = "/dados-token";

    @Test
    @DisplayName("Usuário logado deve conseguir acessar endpoint protegido")
    void usuarioLogadoDeveConseguirAcessarEndpointProtegido() throws Exception {
        // Crie um usuário e gere um token JWT válido para ele
        UserDetails userDetails = userDetailsService.loadUserByUsername("username");
        String token = tokenService.gerarToken(userDetails);

        // Envie uma solicitação com o token JWT válido no cabeçalho Authorization
        MvcResult result = mvc.perform(get(DADOS_TOKEN_ENDPOINT)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isOk())
                .andReturn();

        // Verifique se o corpo da resposta contém os dados do token JWT
        String responseBody = result.getResponse().getContentAsString();
        assertThat(responseBody).contains("tokenJWT");
    }
}*/
