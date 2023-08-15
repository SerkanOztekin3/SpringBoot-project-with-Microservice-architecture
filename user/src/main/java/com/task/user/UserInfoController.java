package com.task.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserInfoController {

	private final UserInfoService userInfoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody UserInfo userInfo){
		userInfoService.saveUser(userInfo);
	}

	@GetMapping
	public ResponseEntity<List<UserInfo>> getAllUser() {
		 return ResponseEntity.ok(userInfoService.findAllUser());
	}

	@GetMapping("/company/{company-id}")
	public ResponseEntity<List<UserInfo>> getAllUser(@PathVariable("company-id") Long companyId ) {
		return ResponseEntity.ok(userInfoService.findAllUserBySchool(companyId));
	}

	@GetMapping("/{username}")
	public ResponseEntity<UserInfo> findUserByName(@PathVariable String username) {
		return ResponseEntity.ok(userInfoService.findUserByUsername(username));
	}
}
