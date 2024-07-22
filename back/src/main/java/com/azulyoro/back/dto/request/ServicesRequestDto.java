package com.azulyoro.back.dto.request;

import com.azulyoro.back.model.ServiceStatus;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicesRequestDto {
    @Min(value = 1, message = "{request.invalid.id_min}")
    private Long clientId;
    @Min(value = 1, message = "{request.invalid.id_min}")
    private Long vehicleId;

    private List<Long> sparePartsIds;

    private List<Long> employeesIds;

    @Min(value = 1, message = "{request.invalid.id_min}")
    private Long serviceTypeId;

    private LocalDate startDate;
    private LocalDate finalDate;
    private ServiceStatus status;
}
