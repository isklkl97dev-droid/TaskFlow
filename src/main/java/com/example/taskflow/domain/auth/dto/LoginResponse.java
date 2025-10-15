package com.example.taskflow.domain.auth.dto;

import lombok.Getter;

@Getter
public class LoginResponse {

    private String email;
    private String name;

    public LoginResponse(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
