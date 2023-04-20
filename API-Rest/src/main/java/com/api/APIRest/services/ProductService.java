package com.api.APIRest.services;

import com.api.APIRest.dtos.ProductDTO;
import com.api.APIRest.models.Product;
import com.api.APIRest.repositorys.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
   public ResponseEntity<?> cadastrar(@RequestBody ProductDTO dados){
        Product product = new Product(dados);
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }
   /* @Transactional
    public void atualizar( Long id, ProductDTO dados){
       var product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
       product.atualizar(dados);
       productRepository.save(product);
       return ResponseEntity.ok();

    }*/

   /* @Transactional
    public ResponseEntity<?> atualizar(Long id, @RequestBody ProductDTO dados){
        var product = productRepository.findByIdIn(dados).orElse(null);
               assert product != null;
        product.atualizar(dados);
        productRepository.save(product);
    }*/

}
