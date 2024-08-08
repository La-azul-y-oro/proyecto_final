package com.azulyoro.back.mapper;

import com.azulyoro.back.dto.request.RegisterRequest;
import com.azulyoro.back.dto.response.EmployeeBasicResponseDto;
import com.azulyoro.back.dto.response.EmployeeResponseDto;
import com.azulyoro.back.model.Employee;
import com.azulyoro.back.model.IdentificationType;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements Mapper<Employee, RegisterRequest, EmployeeResponseDto>{

    public EmployeeBasicResponseDto entityToBasicDto(Employee employee) {
        EmployeeBasicResponseDto employeeDto = new EmployeeBasicResponseDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setDeleted(employee.isDeleted());

        return employeeDto;
    }

    @Override
    public EmployeeResponseDto entityToDto(Employee employee) {
        EmployeeResponseDto dto = new EmployeeResponseDto();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setLastName(employee.getLastName());
        dto.setIdentificationNumber(employee.getIdentificationNumber());
        dto.setEmail(employee.getEmail());
        dto.setRole(employee.getRole());
        dto.setAddress(employee.getAddress());
        dto.setDeleted(employee.isDeleted());

        return dto;
    }

    @Override
    public Employee dtoToEntity(RegisterRequest request) {
        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setLastName(request.getLastName());
        employee.setCategory(IdentificationType.DNI);
        employee.setIdentificationNumber(request.getIdentificationNumber());
        employee.setEmail(request.getEmail());
        employee.setRole(request.getRole());
        employee.setAddress(request.getAddress());

        return employee;
    }
}
