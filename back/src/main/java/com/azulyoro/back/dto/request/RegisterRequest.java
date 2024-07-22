package com.azulyoro.back.dto.request;

import com.azulyoro.back.model.Address;
import com.azulyoro.back.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String lastName;
    private String email;
    private Long identificationNumber;
    private Role role;
    private Address address;
    private String password;
}
