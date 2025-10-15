package com.example.taskflow.domain.auth.dto;

import lombok.Getter;

@Getter
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
}
