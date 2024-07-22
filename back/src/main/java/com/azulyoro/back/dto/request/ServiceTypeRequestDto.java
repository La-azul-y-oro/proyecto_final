package com.azulyoro.back.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceTypeRequestDto {
    @NotBlank(message = "{request.invalid.blank}")
    @Size(max = 50, message = "{request.invalid.max_size}")
    private String name;
    @Size(max = 255, message = "{request.invalid.max_size}")
    private String description;
}
