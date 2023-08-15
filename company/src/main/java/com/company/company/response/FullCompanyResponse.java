package com.company.company.response;

import com.company.company.modal.UserInfo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullCompanyResponse {

	private String companyName;
	List<UserInfo> userInfoList;
}
