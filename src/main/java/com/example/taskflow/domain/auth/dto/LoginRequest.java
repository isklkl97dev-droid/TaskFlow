package com.example.taskflow.domain.auth.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String email;
    private String password;
}
