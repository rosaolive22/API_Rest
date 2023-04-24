package com.api.APIRest.controllers;

import com.api.APIRest.dtos.CatalogDTO;
import com.api.APIRest.models.Catalog;
import com.api.APIRest.repositorys.CatalogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("catalog")
public class CatalogController {
    @Autowired
    private CatalogRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CatalogDTO dados, UriComponentsBuilder uriBuilder){
        var catalog = new Catalog(dados);
        repository.save(catalog);
        var uri = uriBuilder.path("/catalog/{id}").buildAndExpand(catalog.getId()).toUri();
        return ResponseEntity.created(uri).body(catalog);

    }
    @GetMapping
    public ResponseEntity<?> listar(@PageableDefault() Pageable paginacao) {
        var page = repository.findAll(paginacao);
        if (page.isEmpty()){
            return ResponseEntity.badRequest().body("Lista vazia.");
        }
        return ResponseEntity.ok(page);
    }
    //Id dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid CatalogDTO dados, @PathVariable Long id){
        Catalog catalog= repository.findById(id).orElse(null);
        assert catalog != null;
        catalog.atualizar(dados);
        repository.save(catalog);
        return ResponseEntity.ok().body(catalog);
    }
    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        //Exclui definitivamente:
        repository.deleteById(id);
        ObjectMapper mapper = new ObjectMapper();
        Catalog catalogAtivo = new Catalog();
        return ResponseEntity.ok().body(catalogAtivo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id){
        var catalog  = repository.getReferenceById(id);
        return ResponseEntity.ok(catalog);
    }
}
