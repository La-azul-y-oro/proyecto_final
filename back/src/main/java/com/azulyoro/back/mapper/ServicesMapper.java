package com.azulyoro.back.mapper;

import com.azulyoro.back.dto.*;
import com.azulyoro.back.dto.request.ServicesRequestDto;
import com.azulyoro.back.dto.response.EmployeeBasicResponseDto;
import com.azulyoro.back.dto.response.ServicesBasicResponseDto;
import com.azulyoro.back.dto.response.ServicesForVehicleDto;
import com.azulyoro.back.dto.response.ServicesResponseDto;
import com.azulyoro.back.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicesMapper implements Mapper<Services, ServicesRequestDto, ServicesResponseDto> {
    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private ServiceTypeMapper serviceTypeMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SparePartMapper spartPartMapper;

    @Override
    public ServicesResponseDto entityToDto(Services service){
        return ServicesResponseDto.builder()
                .id(service.getId())
                .serviceType(serviceTypeMapper.entityToDto(service.getServiceType()))
                .status(service.getStatus())
                .price(service.getPrice())
                .startDate(service.getStartDate())
                .finalDate(service.getFinalDate())
                .vehicle(vehicleMapper.entityToBasicDto(service.getVehicle()))
                .employees(getEmployeesDto(service))
                .spareParts(getSparePartsDto(service))
                .payDate((service.getPay() != null) ? service.getPay().getDate() : null)
                .build();
    }

    @Override
    public Services dtoToEntity(ServicesRequestDto serviceRequestDto){
        return Services.builder()
                .startDate(serviceRequestDto.getStartDate())
                .startDate(serviceRequestDto.getFinalDate())
                .status(serviceRequestDto.getStatus())
                .build();
    }

    public ServicesBasicResponseDto entityToBasicDto(Services service){
        return ServicesBasicResponseDto.builder()
                .id(service.getId())
                .serviceType(service.getServiceType().getName())
                .status(service.getStatus())
                .vehicle(vehicleMapper.entityToBasicDto(service.getVehicle()))
                .price(service.getPrice())
                .startDate(service.getStartDate())
                .finalDate(service.getFinalDate())
                .payDate((service.getPay() != null) ? service.getPay().getDate() : null)
                .build();
    }

    public ServicesForVehicleDto entityToServiceForVehicleDto(Services service){
        return ServicesForVehicleDto.builder()
                .id(service.getId())
                .serviceType(service.getServiceType().getName())
                .status(service.getStatus())
                .price(service.getPrice())
                .startDate(service.getStartDate())
                .finalDate(service.getFinalDate())
                .payDate((service.getPay() != null) ? service.getPay().getDate() : null)
                .build();
    }

    private List<SparePartResponseDto> getSparePartsDto(Services service){
        return service.getSpareParts()
                .stream()
                .map(spartPartMapper::entityToDto)
                .toList();
    }

    private List<EmployeeBasicResponseDto> getEmployeesDto(Services service){
        return service.getEmployees()
                .stream()
                .map(employeeMapper::entityToBasicDto)
                .toList();
    }
}
