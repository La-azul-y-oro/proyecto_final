package com.azulyoro.back.dto;

import com.azulyoro.back.model.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierResponseDto {
    private Long id;
    private String name;
    private Address address;
    private String phone;
    private String email;
    private boolean isDeleted;
}
