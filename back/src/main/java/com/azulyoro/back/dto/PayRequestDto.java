package com.azulyoro.back.dto;

import com.azulyoro.back.model.PaymentType;
import com.azulyoro.back.model.Services;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.aspectj.bridge.IMessage;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayRequestDto {

    @PastOrPresent(message = "{request.invalid.date}")
    private LocalDate date;
    @Min(value = 1, message = "{request.invalid.id_min}")
    private Long paymentTypeId;

    private List<Long> serviceIds;

}
