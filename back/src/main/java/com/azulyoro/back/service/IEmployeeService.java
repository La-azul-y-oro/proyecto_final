package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.response.EmployeeResponseDto;
import com.azulyoro.back.model.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Optional<Employee> findById(Long id);
    EmployeeResponseDto getById(Long id);
    List<EmployeeResponseDto> getAll();
    CustomPage<EmployeeResponseDto> getByPage(Pageable pageable);
    void delete(Long id);
}
