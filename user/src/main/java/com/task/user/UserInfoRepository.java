package com.task.user;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "user")
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	List<UserInfo> findAllByCompanyId(Long companyId);

	UserInfo findByUsername(String username);
}
