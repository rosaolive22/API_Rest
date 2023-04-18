/*package com.api.APIRest.controllers;

import com.api.APIRest.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

//Utiliza o banco do projeto
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )//não subistitui dados do banco meu banco
@ActiveProfiles("test")
class RepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
   */ //private TestEntityManager em;
  /*  @Test
    @DisplayName("Devolve null quando o produto já existir (nome igual não pode).");*/
   /* void cadastrarProductJaExist() {

        //Precisa criar product para conseguir simular
        var product Product = cadastrarProduct("Product", "CANA", "ELÉTRICO", "DISPONÍVEL")

        productRepository.
    }
    //Métodos privados que seram utilizados em todos cenário de teste:
    private Product cadastrarProduct(String name, Culture culture, Category category, Status status) {
        var product = new Product(dadosProduct(name, culture, category, status));
        em.persist(product);
        return product;
    }

    private DadosCadastroProduct dadosProduct(String name, Culture culture, Category category, Status status){
        return new DadosCadastroProduct(
                name,
                culture,
                category,
                status
        );*/
   // }



