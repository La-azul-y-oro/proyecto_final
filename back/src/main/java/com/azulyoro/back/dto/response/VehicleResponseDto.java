package com.azulyoro.back.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleResponseDto {
    private Long id;
    private String plate;
    private BrandResponseDto brandDto;
    private String model;
    private Integer mileage;
    private String observations;
    private boolean isDeleted;
    private List<ServicesForVehicleDto> services;
}
