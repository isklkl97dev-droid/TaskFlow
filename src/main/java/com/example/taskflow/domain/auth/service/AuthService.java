package com.example.taskflow.domain.auth.service;

import com.example.taskflow.domain.auth.dto.LoginRequest;
import com.example.taskflow.domain.auth.dto.LoginResponse;
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

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new RuntimeException()); // todo: 커스텀 에외처리 기능 추가후 예외처리 예정

        if (!request.getPassword().equals(user.getPassword())) {
           //todo : 비밀번호 틀릴때 예외처리
           throw new RuntimeException();
        }

        return new LoginResponse(user.getEmail(), user.getName());
    }
}
