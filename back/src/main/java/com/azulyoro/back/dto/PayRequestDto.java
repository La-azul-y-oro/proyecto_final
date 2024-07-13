package com.azulyoro.back.dto;

import com.azulyoro.back.model.PaymentType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayRequestDto {

    //@NotBlank(message = "{request.invalid,blank}")
    private LocalDate date;
    @Min(value = 1, message = "request.invalid.id_min")
    private Long paymentTypeId;

}
