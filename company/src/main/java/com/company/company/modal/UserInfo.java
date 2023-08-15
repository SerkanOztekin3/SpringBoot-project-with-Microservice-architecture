package com.company.company.modal;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {

	private String firstname;
	private String lastname;
	private String userRole;
}
