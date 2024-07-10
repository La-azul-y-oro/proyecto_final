package com.azulyoro.back.mapper;

import org.springframework.stereotype.Component;

import com.azulyoro.back.dto.VehicleRequestDto;
import com.azulyoro.back.dto.VehicleResponseDto;
import com.azulyoro.back.model.Vehicle;

@Component
public class VehicleMapper implements Mapper<Vehicle, VehicleRequestDto, VehicleResponseDto> {

    @Override
    public VehicleResponseDto entityToDto(Vehicle vehicle) {
        return VehicleResponseDto.builder()
                .id(vehicle.getId())
                .plate(vehicle.getPlate())
                .brand(vehicle.getBrand())
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
                .brand(vehicleRequestDto.getBrand())
                .model(vehicleRequestDto.getModel())
                .mileage(vehicleRequestDto.getMileage())
                .observations(vehicleRequestDto.getObservations())
                .build();
    }
}
