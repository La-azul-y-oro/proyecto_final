package com.azulyoro.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.azulyoro.back.dto.AuthResponse;
import com.azulyoro.back.dto.LoginRequest;
import com.azulyoro.back.dto.RegisterRequest;
import com.azulyoro.back.model.Employee;
import com.azulyoro.back.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        Employee employee = employeeRepository.findByEmail(loginRequest.getEmail()).orElseThrow();

        String token = jwtService.getToken(employee);

        return AuthResponse
                .builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        return AuthResponse.builder().build();
    }

}
