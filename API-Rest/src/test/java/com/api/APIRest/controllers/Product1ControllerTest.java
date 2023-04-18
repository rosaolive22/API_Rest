//package com.api.APIRest.controllers;
//
//import com.api.APIRest.dtos.ProductDTO;
//import com.api.APIRest.enuns.Category;
//import com.api.APIRest.enuns.Culture;
//import com.api.APIRest.enuns.Status;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//
//@SpringBootTest
////@RunWith
//@AutoConfigureMockMvc
//@AutoConfigureJsonTesters
//class Product1ControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    @Autowired
//    private JacksonTester<ProductDTO> dadosProductJson;
//
//
//    @Test
//    @DisplayName("Retorno codigo 400, informacoes faltantes.")
//    @WithMockUser(username = "john@gmail.api", roles = "USER")
//    void cadastrar_cenario1() throws Exception {
//        var response = mvc.perform(post("/product"))
//            .andReturn().getResponse();
//
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
//    }
//@Test
//@DisplayName("Retorno codigo 200, informacoes validas.")
//@WithMockUser//(username = "john@gmail.api", roles = "USER")
//void cadastrar_cenario2() throws Exception {
//
//    var name = new String("Condorito 800");
//    var price = 15000000f;
//    var description = new String("Breve descrição");
//    var culture = Culture.CANA;
//    var category = Category.COMBUSTÍVEL;
//    var status = Status.DISPONÍVEL;
//
//    var response = mvc.perform(post("/product")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(dadosProductJson.write(
//                            new ProductDTO(name,price,description,culture,category,"")
//                    ).getJson())
//            )
//            .andReturn().getResponse();
//
//    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//
//    var jsonEsperado = dadosProductJson.write(new ProductDTO(name,price,description,culture,category,status)
//    ).getJson();
//    assertThat(response.getContentAsString()).isEqualTo((jsonEsperado));
//}
//
//}