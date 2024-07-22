package com.azulyoro.back.dto.request;

import com.azulyoro.back.model.PaymentCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class PaymentTypeRequestDto {
    @NotBlank(message = "{request.invalid.blank}")
    private String name;
    @NotNull(message = "{request.invalid.null}")
    private PaymentCategory category;
}
