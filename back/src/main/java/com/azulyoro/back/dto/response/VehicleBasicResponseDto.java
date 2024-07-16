package com.azulyoro.back.dto.response;

import com.azulyoro.back.dto.BrandResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleBasicResponseDto {
    private String plate;
    private String brand;
    private String model;
    private Integer mileage;
    private String observations;
}
