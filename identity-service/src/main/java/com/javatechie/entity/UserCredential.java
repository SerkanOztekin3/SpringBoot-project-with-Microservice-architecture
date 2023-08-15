package com.javatechie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredential {
    private Long id;
    private String firstname;
    private String lastname;
    private String userRole;
    private Long companyId;
    private String username;
    private String password;
}
