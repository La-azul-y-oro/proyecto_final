package com.azulyoro.back.dto.response;

import com.azulyoro.back.model.PaymentCategory;
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
public class PaymentTypeResponseDto {
    private Long id;
    private String name;
    private PaymentCategory category;
    private boolean isDeleted;
}
