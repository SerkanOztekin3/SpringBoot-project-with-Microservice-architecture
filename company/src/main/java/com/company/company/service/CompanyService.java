package com.company.company.service;

import com.company.company.client.UserClient;
import com.company.company.modal.Company;
import com.company.company.repository.CompanyRepository;
import com.company.company.response.FullCompanyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyRepository companyRepository;

	private final UserClient userClient;

	public void createCompany(Company company) { companyRepository.save(company);}

	public List<Company> findAllCompany() { return companyRepository.findAll(); }

	public FullCompanyResponse findCompaniesWithStudent(Long companyId) {
		var company = companyRepository.findById(companyId)
				.orElse(Company.builder()
						.companyName("NOT_FOUND")
						.build());

		var userInfo = userClient.findAllUserByCompany(companyId);
		return FullCompanyResponse.builder().
				companyName(company.getCompanyName())
				.userInfoList(userInfo)
				.build();
	}
}
