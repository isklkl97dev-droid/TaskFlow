package com.example.taskflow.domain.auth.dto;

import lombok.Getter;

@Getter
public class RegisterResponse {
    private String email;
    private String name;

    public RegisterResponse(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
