package com.company.company.controller;

import com.company.company.modal.Company;
import com.company.company.response.FullCompanyResponse;
import com.company.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@PostMapping
	public void createCompany(@RequestBody Company company) {
		companyService.createCompany(company);
	}

	@GetMapping
	public ResponseEntity<List<Company>> findAllCompany() { return  ResponseEntity.ok(companyService.findAllCompany());}

	@GetMapping("with-user/{company-id}")
	public ResponseEntity<FullCompanyResponse> findAllCompany(@PathVariable("company-id") Long companyId) {
		return ResponseEntity.ok(companyService.findCompaniesWithStudent(companyId));
	}
}
