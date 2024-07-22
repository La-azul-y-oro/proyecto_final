package com.azulyoro.back.dto.request;

import com.azulyoro.back.util.RegexPatterns;
import jakarta.validation.constraints.*;
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

    @Pattern(regexp = RegexPatterns.VEHICLE_PLATE, message="{request.invalid.plate}")
    private String plate;

    @Min(value=1, message = "{request.invalid.id_min}")
    private Long brandId;

    @NotBlank(message = "{request.invalid.blank}")
    @Size(max = 50, message = "{request.invalid.max_size}")
    private String model;

    @Min(value = 0, message = "{request.invalid.mileage}")
    private Integer mileage;

    @Size(max = 300, message = "{request.invalid.max_size}")
    private String observations;
}
