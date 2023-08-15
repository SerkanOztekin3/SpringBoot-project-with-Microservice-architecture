package com.task.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoService {

	private final UserInfoRepository userInfoRepository;

	public void saveUser(UserInfo userInfo) {
		userInfoRepository.save(userInfo);
	}

	public List<UserInfo> findAllUser() {
		return userInfoRepository.findAll();
	}

	public List<UserInfo> findAllUserBySchool(Long companyId) {
		return userInfoRepository.findAllByCompanyId(companyId);
	}

	public UserInfo findUserByUsername(String username) {
		return userInfoRepository.findByUsername(username);
	}
}
