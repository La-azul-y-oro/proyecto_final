package com.azulyoro.back.dto;

import com.azulyoro.back.model.Brand;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class VehicleRequestDto {

    @NotBlank(message = "{request.invalid.blank}")
    private String plate;

    @NotNull(message = "{request.invalid.brand}")
    private Brand brand;

    @NotBlank(message = "{request.invalid.model}")
    @Size(max = 50, message = "{request.invalid.model.size}")
    private String model;

    @Min(value = 0, message = "Mileage must be positive")
    private Number mileage;

    @Size(max = 300, message = "{request.invalid.observations.size}")
    private String observations;
}
