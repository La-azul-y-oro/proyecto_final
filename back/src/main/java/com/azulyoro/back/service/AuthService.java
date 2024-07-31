package com.azulyoro.back.service;

import com.azulyoro.back.dto.request.LoginRequest;
import com.azulyoro.back.dto.request.RegisterRequest;
import com.azulyoro.back.dto.response.AuthResponse;
import com.azulyoro.back.exception.UserInactiveException;
import com.azulyoro.back.exception.UserNotFoundException;
import com.azulyoro.back.mapper.EmployeeMapper;
import com.azulyoro.back.model.Employee;
import com.azulyoro.back.repository.EmployeeRepository;
import com.azulyoro.back.util.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeMapper employeeMapper;

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        Optional<Employee> employeeOptional = employeeRepository.findByEmail(loginRequest.getEmail());

        if (employeeOptional.isEmpty()) {
            throw new UserNotFoundException(MessageUtil.userNotFound(loginRequest.getEmail()));
        }

        if (employeeOptional.get().isDeleted()) {
            throw new UserInactiveException(MessageUtil.userInactive(loginRequest.getEmail()));
        }

        Employee employee = employeeOptional.get();

        String token = jwtService.getToken(employee);

        return AuthResponse
                .builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest registerRequest){
        Employee employee = employeeService.createEmployee(registerRequest);

        String token = jwtService.getToken(employee);

        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
