package com.api.APIRest.dtos;

import com.api.APIRest.models.Order;


public record DetalhesOdDTO(String name, String phone, String e_mail, String country) {
    public DetalhesOdDTO(Order order) {
        this(order.getName(),
                order.getPhone(),
                order.getE_mail(),
                order.getCountry());
    }
}
