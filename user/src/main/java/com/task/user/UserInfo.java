package com.task.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long userId;
	private String firstname;
	private String lastname;
	private String userRole;
	private Long companyId;
	private String username;
	private String password;
}
