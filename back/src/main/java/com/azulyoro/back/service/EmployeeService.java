package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.RegisterRequest;
import com.azulyoro.back.dto.response.ClientResponseDto;
import com.azulyoro.back.dto.response.EmployeeResponseDto;
import com.azulyoro.back.dto.response.ServicesBasicResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.exception.FieldNotValidException;
import com.azulyoro.back.exception.UserAlreadyRegistered;
import com.azulyoro.back.mapper.EmployeeMapper;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.mapper.ServicesMapper;
import com.azulyoro.back.model.Brand;
import com.azulyoro.back.model.Client;
import com.azulyoro.back.model.Employee;
import com.azulyoro.back.repository.EmployeeRepository;
import com.azulyoro.back.util.MessageUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ServicesMapper servicesMapper;

    @Autowired
    private PageMapper pageMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeResponseDto create(RegisterRequest registerRequest) {
        return employeeMapper.entityToDto(createEmployee(registerRequest));
    }

    @Override
    public EmployeeResponseDto update(Long id, RegisterRequest registerRequest) {
        Employee currentEmployee = employeeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        Employee newEmployee = validateAndProcessUpdateRequest(id, registerRequest);
        newEmployee.setId(id);
        newEmployee.setPassword(currentEmployee.getPassword());

        return employeeMapper.entityToDto(employeeRepository.save(newEmployee));
    }

    @Override
    public EmployeeResponseDto getById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        EmployeeResponseDto dto = employeeMapper.entityToDto(employee);
        dto.setServices(getServicesDto(employee));

        return dto;
    }

    @Override
    public List<EmployeeResponseDto> getAll() {
        return employeeRepository
                .findAll()
                .stream()
                .map( e -> {
                    var dto = employeeMapper.entityToDto(e);
                    dto.setServices(getServicesDto(e));
                    return dto;
                })
                .toList();
    }

    @Override
    public CustomPage<EmployeeResponseDto> getByPage(Pageable pageable) {
        Page<EmployeeResponseDto> page = employeeRepository
                .findAll(pageable)
                .map( e -> {
                    var dto = employeeMapper.entityToDto(e);
                    dto.setServices(getServicesDto(e));
                    return dto;
                });

        return pageMapper.pageToCustomPage(page);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        try {
            employeeRepository.softDelete(id);
        } catch (Exception e) {
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }

    private List<ServicesBasicResponseDto> getServicesDto(Employee employee){
        return Optional.ofNullable(employee.getServices())
                .orElse(Collections.emptyList())
                .stream()
                .map(servicesMapper::entityToBasicDto)
                .toList();
    }

    private Employee validateAndProcessRequest(RegisterRequest registerRequest) {
        String email = registerRequest.getEmail();
        Long idNumber = registerRequest.getIdentificationNumber();

        if (employeeRepository.existsByEmail(email))
            throw new UserAlreadyRegistered(MessageUtil.emailAlreadyRegistered(email));

        if (employeeRepository.existsByIdentificationNumber(idNumber))
            throw new UserAlreadyRegistered(MessageUtil.idNumberAlreadyRegistered(idNumber));

        Employee employee = employeeMapper.dtoToEntity(registerRequest);
        employee.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        return employee;
    }

    private Employee validateAndProcessUpdateRequest(Long id, RegisterRequest registerRequest) {
        String email = registerRequest.getEmail();
        Long idNumber = registerRequest.getIdentificationNumber();

        if (employeeRepository.existsByEmailExcludingId(id, email))
            throw new UserAlreadyRegistered(MessageUtil.emailAlreadyRegistered(email));

        if (employeeRepository.existsByIdentificationNumberExcludingId(id, idNumber))
            throw new UserAlreadyRegistered(MessageUtil.idNumberAlreadyRegistered(idNumber));

        Employee employee = employeeMapper.dtoToEntity(registerRequest);

        return employee;
    }

    public Employee createEmployee(RegisterRequest registerRequest) {
        if (registerRequest.getPassword() == null) {
            throw new FieldNotValidException(MessageUtil.fieldNotValid("Password", "null"));
        }

        Employee employee = validateAndProcessRequest(registerRequest);

        return employeeRepository.save(employee);
    }
}
