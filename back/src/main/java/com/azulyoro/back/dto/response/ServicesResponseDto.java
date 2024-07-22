package com.azulyoro.back.dto.response;

import com.azulyoro.back.model.ServiceStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServicesResponseDto{
    private Long id;
    private ServiceTypeResponseDto serviceType;
    private ServiceStatus status;
    private LocalDate payDate;
    private Double price;
    private LocalDate startDate;
    private LocalDate finalDate;
    private VehicleBasicResponseDto vehicle;
    private ClientBasicResponseDto client;
    private List<EmployeeBasicResponseDto> employees;
    private List<SparePartResponseDto> spareParts;
}
