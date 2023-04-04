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

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    CatalogRepository catalogRepository;
   /* public ResponseEntity<?> cadastrar(@RequestBody ProductDTO dados){
        List<Image>images = imageRepository.findByIdIn(dados.imgsIds());
        List<Catalog>catalogs = catalogRepository.findByIdIn(dados.catalogIds());
        Product product = new Product(dados,images,catalogs);
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }*/
   /* public ResponseEntity<?> updadte(@RequestBody ProductDTO dados){
        Product product = productRepository.findByIdIn(dados).orElse(null);
        List<Image> imgs = imageRepository.findByIdIn(dados.imgsIds());
        List<Catalog> catalogs = catalogRepository.findByIdIn(dados.catalogIds());
        assert product != null;
        product.atualizar(dados,imgs, catalogs);
        productRepository.save(product);
    }*/

}
