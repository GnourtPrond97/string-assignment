package com.example.assignment_spring_boot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String id;
    private String username;
    private String fullName;
    private String passwordHash;
    private int status;
    private int role;
}
