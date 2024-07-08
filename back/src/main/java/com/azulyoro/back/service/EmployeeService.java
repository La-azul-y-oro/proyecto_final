package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EntityService<Employee, Employee>{

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
}
