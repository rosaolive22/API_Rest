package com.api.APIRest.repositorys;

import com.api.APIRest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIdIn(List<Long> productIds);
    //Page<Product> findAllByAtivoTrue(Pageable paginacao);

}
