package com.azulyoro.back.dto;

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
    private BrandResponseDto brandDto;
    private String model;
    private Integer mileage;
    private String observations;
    private boolean isDeleted;
}
