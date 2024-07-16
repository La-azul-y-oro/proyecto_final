package com.azulyoro.back.mapper;

import com.azulyoro.back.dto.response.EmployeeBasicResponseDto;
import com.azulyoro.back.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper{
    public EmployeeBasicResponseDto entityToBasicDto(Employee employee) {
        EmployeeBasicResponseDto employeeDto = new EmployeeBasicResponseDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setLastName(employee.getLastName());

        return employeeDto;
    }

}
