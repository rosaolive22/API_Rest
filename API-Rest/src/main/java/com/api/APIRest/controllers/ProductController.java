package com.api.APIRest.controllers;

import com.api.APIRest.dtos.DetalhesPdDTO;
import com.api.APIRest.dtos.ProductDTO;
import com.api.APIRest.models.Product;
import com.api.APIRest.repositorys.ProductRepository;
import com.api.APIRest.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("product")
@SecurityRequirement(name = "bearer-key")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @PostMapping
    @Operation(summary = "Cadastrar novo produto.")
    @Transactional //12/04
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ProductDTO dados, UriComponentsBuilder uriBuilder) {
           return productService.cadastrar(dados);
       /*var product = new Product(dados);
        productRepository.save(product);
        var uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(product);*/
    }
    @GetMapping
    @Operation(summary = "Devolve uma listar de produtos cadastrados.")
    public ResponseEntity<?> listar(@PageableDefault(size=10) Pageable paginacao){
        var page = productRepository.findAll(paginacao);
        if (page.isEmpty()){
            return ResponseEntity.badRequest().body("Lista vazia.");
        }
        return ResponseEntity.ok(page);
    }
    //Dividindo o Controller com Service
   /* @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid ProductDTO dados, @PathVariable Long id){
        Product productAtualizado = productService.atualizar(dados);
        return ResponseEntity.ok().body(productAtualizado);
    }*/
    @PutMapping(value = "/{id}")
    @Operation(summary = "Atualizar informações de um determinado produto informando seu id.")
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid ProductDTO dados, @PathVariable Long id){
       /* productService.atualizar(id, dados);
        return ResponseEntity.ok().body(new ProductDTO(product));*/

        var product= productRepository.findById(id).orElse(null);
        assert product != null;
        product.atualizar(dados);
        productRepository.save(product);
        return ResponseEntity.ok().body(product);
    }
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Excluir produto informando seu id.")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id){
        //Excluir definitivamente:
        productRepository.deleteById(id);
        ObjectMapper mapper = new ObjectMapper();
        Product productAtivo = new Product();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Detalhar informações de um determinado produto, informando o id correspondente.")
    public ResponseEntity detalhar(@PathVariable Long id){
        var product  = productRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPdDTO(product));
    }
}
