package com.api.APIRest.models;

import com.api.APIRest.dtos.CatalogDTO;
import com.api.APIRest.enuns.Category;
import com.api.APIRest.enuns.Culture;
import com.api.APIRest.enuns.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Table(name = "tb_catalog")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Culture culture;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotBlank
    private String linha;
    private Boolean ativo;

    public Catalog(CatalogDTO dados) {
        this.culture = dados.culture();
        this.linha = dados.linha();
        this.ativo = true;
    }
    public void atualizar(CatalogDTO dados) {
        if(dados.culture() != null){
            this.culture = dados.culture();
        }
        if(dados.linha() != null){
            this.linha = dados.linha();
        }
    }
    public void excluir() {
        this.ativo = false;
    }
}
