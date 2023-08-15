package com.company.company.client;

import com.company.company.modal.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service", url = "${application.config.user-url}")
public interface UserClient {
	@GetMapping("/company/{company-id}")
	List<UserInfo> findAllUserByCompany(@PathVariable("company-id") Long companyId);
}
