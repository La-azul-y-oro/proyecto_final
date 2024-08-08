package com.azulyoro.back.dto.response;

import com.azulyoro.back.model.Address;
import com.azulyoro.back.model.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponseDto extends EmployeeBasicResponseDto {
    private List<ServicesBasicResponseDto> services;
    private String email;
    private Long identificationNumber;
    private Role role;
    private Address address;
}
