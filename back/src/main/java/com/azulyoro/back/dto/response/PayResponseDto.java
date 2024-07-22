package com.azulyoro.back.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayResponseDto {
    private Long id;
    private LocalDate date;
    private PaymentTypeResponseDto paymentTypeResponseDto;
    private boolean isDeleted;
}
