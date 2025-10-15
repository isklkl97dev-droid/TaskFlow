package com.example.taskflow.domain.auth.controller;

import com.example.taskflow.domain.auth.dto.LoginRequest;
import com.example.taskflow.domain.auth.dto.LoginResponse;
import com.example.taskflow.domain.auth.dto.RegisterRequest;
import com.example.taskflow.domain.auth.dto.RegisterResponse;
import com.example.taskflow.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return  ResponseEntity.ok(authService.login(request));
    }
}
