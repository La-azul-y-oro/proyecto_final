package com.azulyoro.back.mapper;

import com.azulyoro.back.dto.request.VehicleRequestDto;
import com.azulyoro.back.dto.response.VehicleBasicResponseDto;
import com.azulyoro.back.dto.response.VehicleResponseDto;
import com.azulyoro.back.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleMapper implements Mapper<Vehicle, VehicleRequestDto, VehicleResponseDto> {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public VehicleResponseDto entityToDto(Vehicle vehicle) {
        return VehicleResponseDto.builder()
                .id(vehicle.getId())
                .plate(vehicle.getPlate())
                .brandDto(brandMapper.entityToDto(vehicle.getBrand()))
                .model(vehicle.getModel())
                .mileage(vehicle.getMileage())
                .observations(vehicle.getObservations())
                .isDeleted(vehicle.isDeleted())
                .build();
    }

    @Override
    public Vehicle dtoToEntity(VehicleRequestDto vehicleRequestDto) {
        return Vehicle.builder()
                .plate(vehicleRequestDto.getPlate())
                .model(vehicleRequestDto.getModel())
                .mileage(vehicleRequestDto.getMileage())
                .observations(vehicleRequestDto.getObservations())
                .build();
    }

    public VehicleBasicResponseDto entityToBasicDto(Vehicle vehicle) {
        return VehicleBasicResponseDto.builder()
                .plate(vehicle.getPlate())
                .brand(vehicle.getBrand().getName())
                .model(vehicle.getModel())
                .mileage(vehicle.getMileage())
                .observations(vehicle.getObservations())
                .build();
    }
}
