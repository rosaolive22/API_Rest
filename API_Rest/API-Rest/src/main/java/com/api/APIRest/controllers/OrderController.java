package com.api.APIRest.controllers;

import com.api.APIRest.dtos.OrderDTO;
import com.api.APIRest.models.Order;
import com.api.APIRest.repositorys.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody OrderDTO dados, UriComponentsBuilder uriBuilder) {
        var order = new Order(dados);
        //Company newcompany = new Company(dados);
        repository.save(order);
        var uri = uriBuilder.path("/company/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }
    @GetMapping
    public ResponseEntity<?> listar(@PageableDefault() Pageable paginacao){
        var page = repository.findAll(paginacao);
        if (page.isEmpty()){
        return ResponseEntity.badRequest().body("Lista vazia.");
    }
        return ResponseEntity.ok(page);
    }

    //Id dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid OrderDTO dados, @PathVariable Long id) {
        var order = repository.findById(id).orElse(null);
        assert order != null;
        order.atualizar(dados);
        repository.save(order);
        return ResponseEntity.ok().body(order);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        //Exclui definitivamente:
        repository.deleteById(id);
        ObjectMapper mapper = new ObjectMapper();
        Order orderAtivo = new Order();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id){
        var order  = repository.getReferenceById(id);
        return ResponseEntity.ok(order);
    }
}
