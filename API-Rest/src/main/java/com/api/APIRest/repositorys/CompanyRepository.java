package com.api.APIRest.repositorys;

import com.api.APIRest.models.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Page<Company> findAllByAtivoTrue(Pageable paginacao);
}
