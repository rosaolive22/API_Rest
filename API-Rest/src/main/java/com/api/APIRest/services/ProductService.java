package com.api.APIRest.services;

import com.api.APIRest.dtos.ProductDTO;
import com.api.APIRest.models.Catalog;
import com.api.APIRest.models.Image;
import com.api.APIRest.models.Product;
import com.api.APIRest.repositorys.CatalogRepository;
import com.api.APIRest.repositorys.ImageRepository;
import com.api.APIRest.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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
   /* public ResponseEntity<?> updadte(@RequestBody ProductDTO dados){
        Product product = productRepository.findByIdIn(dados).orElse(null);
               assert product != null;
        product.atualizar(dados);
        productRepository.save(product);
    }*/

}
