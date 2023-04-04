package com.api.APIRest.models;

import com.api.APIRest.dtos.ProductDTO;
import com.api.APIRest.enuns.Category;
import com.api.APIRest.enuns.Culture;
import com.api.APIRest.enuns.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.time.LocalDate;


@Table(name = "tb_product")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;
    @NotBlank
    @Column(name = "name",unique = true)
    private String name;
    @NotNull
    @Column(name = "price")
    private Float price;
    @NotBlank
    @Column(name = "description", columnDefinition = "Text")
    private String description;
    @Column(name = "date_register")
    private LocalDate date_register; //= LocalDate.now();
    private Boolean ativo;
    @Enumerated(EnumType.STRING)
    private Culture culture;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Status status;


    public Product(ProductDTO dados) {
        this.name = dados.name();
        this.price = dados.price();
        this.culture = dados.culture();
        this.category = dados.category();
        this.status = dados.status();
        this.description = dados.description();
        this.ativo = true;
    }
    public void atualizar(ProductDTO dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.price() != null){
            this.price = dados.price();
        }
        if (dados.culture() != null) {
            this.culture = dados.culture();
        }
        if (dados.category() != null) {
            this.category = dados.category();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
        if (dados.description() != null){
            this.description =dados.description();
        }
    }
    public void excluir() {
        this.ativo = false;
    }
}

