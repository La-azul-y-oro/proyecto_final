package com.azulyoro.back.service;

import java.util.Optional;

import com.azulyoro.back.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.azulyoro.back.dto.request.LoginRequest;
import com.azulyoro.back.dto.request.RegisterRequest;
import com.azulyoro.back.dto.response.AuthResponse;
import com.azulyoro.back.exception.UserAlreadyRegistered;
import com.azulyoro.back.exception.UserInactive;
import com.azulyoro.back.exception.UserNotFound;
import com.azulyoro.back.model.Employee;
import com.azulyoro.back.model.IdentificationType;
import com.azulyoro.back.repository.EmployeeRepository;
import com.azulyoro.back.util.MessageUtil;

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

    @Autowired
    private EmployeeMapper employeeMapper;

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        Optional<Employee> employeeOptional = employeeRepository.findByEmail(loginRequest.getEmail());

        if (employeeOptional.isEmpty()) {
            throw new UserNotFound(MessageUtil.userNotFound(loginRequest.getEmail()));
        }

        if (employeeOptional.get().isDeleted()) {
            throw new UserInactive(MessageUtil.userInactive(loginRequest.getEmail()));
        }

        Employee employee = employeeOptional.get();

        String token = jwtService.getToken(employee);

        return AuthResponse
                .builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest registerRequest) {

        if (employeeRepository.existsByEmail(registerRequest.getEmail())) {
            throw new UserAlreadyRegistered(MessageUtil.emailAlreadyRegistered(registerRequest.getEmail()));
        }

        if (employeeRepository.existsByIdentificationNumber(registerRequest.getIdentificationNumber())) {
            throw new UserAlreadyRegistered(
                    MessageUtil.idNumberAlreadyRegistered(registerRequest.getIdentificationNumber()));
        }

        Employee employee = employeeMapper.dtoToEntity(registerRequest);

        employee.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        employeeRepository.save(employee);

        String token = jwtService.getToken(employee);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

}
