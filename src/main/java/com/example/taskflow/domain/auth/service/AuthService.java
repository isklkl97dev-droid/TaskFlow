package com.example.taskflow.domain.auth.service;

import com.example.taskflow.domain.auth.dto.RegisterRequest;
import com.example.taskflow.domain.auth.dto.RegisterResponse;
import com.example.taskflow.domain.user.entity.User;
import com.example.taskflow.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            //todo: 중복이메일 에외처리
        }

        User newUser = new User(request.getEmail(), request.getPassword(), request.getName());

        User saveUser = userRepository.save(newUser);

        return new RegisterResponse(saveUser.getEmail(), saveUser.getName());
    }
}
