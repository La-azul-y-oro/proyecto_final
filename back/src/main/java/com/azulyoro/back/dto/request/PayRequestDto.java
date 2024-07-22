package com.azulyoro.back.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

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
