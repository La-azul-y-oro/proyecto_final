package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.model.Employee;
import com.azulyoro.back.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EntityService<Employee, Employee>{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return null;
    }

    @Override
    public Employee getById(Long id) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return List.of();
    }

    @Override
    public CustomPage<Employee> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {}

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }
}
