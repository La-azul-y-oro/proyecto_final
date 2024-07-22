package com.azulyoro.back.mapper;

import org.springframework.stereotype.Component;

import com.azulyoro.back.dto.request.ServiceTypeRequestDto;
import com.azulyoro.back.dto.response.ServiceTypeResponseDto;
import com.azulyoro.back.model.ServiceType;

@Component
public class ServiceTypeMapper implements Mapper<ServiceType, ServiceTypeRequestDto, ServiceTypeResponseDto> {
    
    @Override
    public ServiceTypeResponseDto entityToDto(ServiceType serviceType) {
        return ServiceTypeResponseDto.builder()
                .id(serviceType.getId())
                .name(serviceType.getName())
                .description(serviceType.getDescription())
                .isDeleted(serviceType.isDeleted())
                .build();
    }

    @Override
    public ServiceType dtoToEntity(ServiceTypeRequestDto serviceTypeRequestDto) {
        return ServiceType.builder()
                .name(serviceTypeRequestDto.getName())
                .description(serviceTypeRequestDto.getDescription())
                .build();
    }
}
