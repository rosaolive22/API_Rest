package com.api.APIRest.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//http://localhost:8080/swagger-ui/index.html#/
@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                         .info(new Info()
                        .title("Trevo SA. API-Rest ")
                        .description("API Rest da aplicação Trevo SA, contendo as funcionalidades de CRUD.")
                        .contact(new Contact()
                                .name("Time Backend 2")
                                .email("rosa.marciaolive22@gmail.com")));
    }
    /*catalog  {
        "page": 0,
        "size": 1,
        "sort":{
        "empty": true,
                "sorted": false,
                "unsorted": true
    }}
    {
  "page": 0,
  "size": 10

}*/

    }

