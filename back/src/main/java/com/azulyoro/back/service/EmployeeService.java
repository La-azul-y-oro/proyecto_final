package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.RegisterRequest;
import com.azulyoro.back.dto.response.ClientResponseDto;
import com.azulyoro.back.dto.response.EmployeeResponseDto;
import com.azulyoro.back.dto.response.ServicesBasicResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.mapper.EmployeeMapper;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.mapper.ServicesMapper;
import com.azulyoro.back.model.Employee;
import com.azulyoro.back.repository.EmployeeRepository;
import com.azulyoro.back.util.MessageUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
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
}
