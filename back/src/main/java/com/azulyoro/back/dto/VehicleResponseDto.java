package com.azulyoro.back.dto;

import com.azulyoro.back.model.Brand;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleResponseDto {
    private Long id;
    private String plate;
    private Brand brand;
    private String model;
    private Number mileage;
    private String observations;
}
