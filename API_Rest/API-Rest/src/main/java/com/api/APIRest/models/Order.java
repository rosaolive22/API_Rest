package com.api.APIRest.models;

import com.api.APIRest.dtos.OrderDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Table(name = "tb_order")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Column(name = "name",unique = true)
    private String name;
    @NotNull
    @Column(name = "phone")
    private String phone;
    @NotBlank
    @Email
    @Column(name = "e_mail",unique = true)
    private String e_mail;
    private String country;
    private Boolean ativo;

    public Order(OrderDTO dados) {
        this.name = dados.name();
        this.phone = dados.phone();
        this.e_mail = dados.e_mail();
        this.country = dados.country();
        this.ativo = true;
    }

    public void atualizar(OrderDTO dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.phone() != null) {
            this.phone = dados.phone();
        }
        if (dados.e_mail() != null) {
            this.e_mail = dados.e_mail();
        }
        if (dados.country() != null) {
            this.country = dados.country();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
