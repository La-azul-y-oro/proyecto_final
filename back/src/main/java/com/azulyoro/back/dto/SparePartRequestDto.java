package com.azulyoro.back.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SparePartRequestDto {
    @NotBlank(message = "{request.invalid.blank}")
    private String name;
    @Min(value = 1, message = "{request.invalid.id_min}")
    private Long brandId;
    @NotBlank(message = "{request.invalid.blank}")
    private String madeIn;
}
