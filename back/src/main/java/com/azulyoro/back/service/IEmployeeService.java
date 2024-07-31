package com.azulyoro.back.service;

import com.azulyoro.back.dto.request.RegisterRequest;
import com.azulyoro.back.dto.response.EmployeeResponseDto;
import com.azulyoro.back.model.Employee;

import java.util.Optional;

public interface IEmployeeService extends EntityService<RegisterRequest, EmployeeResponseDto>{
    Optional<Employee> findById(Long id);
}
