package com.azulyoro.back.dto.response;

import com.azulyoro.back.model.ServiceStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServicesBasicResponseDto {
    private Long id;
    private String serviceType;
    private ServiceStatus status;
    private LocalDate payDate;
    private Double price;
    private LocalDate startDate;
    private LocalDate finalDate;
    private VehicleBasicResponseDto vehicle;
}
