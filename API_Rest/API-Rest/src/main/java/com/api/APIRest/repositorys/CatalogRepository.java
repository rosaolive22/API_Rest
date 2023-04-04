package com.api.APIRest.repositorys;

import com.api.APIRest.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog,Long> {
        List<Catalog> findByIdIn (List<Long>catalogsIds);
}
