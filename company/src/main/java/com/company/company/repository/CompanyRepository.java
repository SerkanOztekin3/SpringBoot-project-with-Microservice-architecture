package com.company.company.repository;

import com.company.company.modal.Company;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "company")
public interface CompanyRepository extends JpaRepository<Company, Long> {


}
