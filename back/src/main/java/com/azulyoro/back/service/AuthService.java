package com.azulyoro.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.azulyoro.back.dto.AuthResponse;
import com.azulyoro.back.dto.LoginRequest;
import com.azulyoro.back.dto.RegisterRequest;
import com.azulyoro.back.model.Employee;
import com.azulyoro.back.model.IdentificationType;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        // si ya existe email y/o identificationNumber devolver email/DNI ya usado
        if (employeeRepository.existsByEmail(registerRequest.getEmail())) {
            throw new IllegalArgumentException("Email already used");
        }

        if (employeeRepository.existsByIdentificationNumber(registerRequest.getIdentificationNumber())) {
            throw new IllegalArgumentException("DNI/CUIT already registered");
        }

        Employee employee = new Employee();

        employee.setName(registerRequest.getName());
        employee.setLastName(registerRequest.getLastName());
        employee.setCategory(IdentificationType.DNI);
        employee.setIdentificationNumber(registerRequest.getIdentificationNumber());
        employee.setEmail(registerRequest.getEmail());
        employee.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        employee.setRole(registerRequest.getRole());
        employee.setAddress(registerRequest.getAddress());

        employeeRepository.save(employee);

        String token = jwtService.getToken(employee);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

}
