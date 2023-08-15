package com.javatechie.client;

import com.javatechie.entity.UserCredential;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "user-service", url = "${application.config.user-url}")
public interface UserClient {

	@PostMapping
	void saveUser(@RequestBody UserCredential userCredential);

	@GetMapping("/{username}")
	Optional<UserCredential> findUserByName(@PathVariable String username);
}
