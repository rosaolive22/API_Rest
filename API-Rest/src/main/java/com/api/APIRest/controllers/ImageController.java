package com.api.APIRest.controllers;

import com.api.APIRest.dtos.ImageDTO;
import com.api.APIRest.models.Image;
import com.api.APIRest.repositorys.ImageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("image")
public class ImageController {
    @Autowired
    private ImageRepository repository;
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody ImageDTO dados){
        Image newimage = new Image(dados);
        repository.save(newimage);
        return ResponseEntity.ok().body(newimage);
    }
    @GetMapping
    public Page<Image> listar(@PageableDefault(page = 0, size = 10, sort = {"img"}) Pageable paginacao) {
        return repository.findAll(paginacao);
    }
    //Id(cod) dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid ImageDTO dados, @PathVariable Long id){
        Image image= repository.findById(id).orElse(null);
        assert image != null;
        image.atualizar(dados);
        repository.save(image);
        return ResponseEntity.ok().body(image);
    }
    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        //Exclui definitivamente:
        repository.deleteById(id);
        ObjectMapper mapper = new ObjectMapper();
        Image imageAtivo = new Image();
        return ResponseEntity.ok().body(imageAtivo);
    }
}
