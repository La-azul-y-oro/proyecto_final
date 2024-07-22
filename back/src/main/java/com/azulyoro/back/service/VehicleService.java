package com.azulyoro.back.service;

import java.util.List;
import java.util.Optional;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.VehicleRequestDto;
import com.azulyoro.back.dto.response.ServicesForVehicleDto;
import com.azulyoro.back.dto.response.VehicleResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.exception.EntityNotFoundOrInactiveException;
import com.azulyoro.back.mapper.ClientMapper;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.mapper.ServicesMapper;
import com.azulyoro.back.mapper.VehicleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azulyoro.back.model.Brand;
import com.azulyoro.back.model.Vehicle;
import com.azulyoro.back.repository.VehicleRepository;
import com.azulyoro.back.util.MessageUtil;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class VehicleService implements EntityService<VehicleRequestDto, VehicleResponseDto> {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private ServicesMapper servicesMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private PageMapper pageMapper;

    @Autowired
    private BrandService brandService;

    @Override
    public VehicleResponseDto create(VehicleRequestDto vehicleDto) {

        Optional<Brand> brand = brandService.getBrandEntity(vehicleDto.getBrandId());

        if (brand.isEmpty() || brand.get().isDeleted()) {
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(vehicleDto.getBrandId()));
        }

        Vehicle vehicle = vehicleMapper.dtoToEntity(vehicleDto);
        vehicle.setBrand(brand.get());

        return setServicesAndGetResponseDto(vehicleRepository.save(vehicle));
    }

    @Override
    public VehicleResponseDto update(Long id, VehicleRequestDto vehicleDto) {

        Optional<Brand> brand = brandService.getBrandEntity(vehicleDto.getBrandId());

        if (brand.isEmpty() || brand.get().isDeleted()) {
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(vehicleDto.getBrandId()));
        }

        if (vehicleRepository.existsById(id)) {
            Vehicle vehicle = vehicleMapper.dtoToEntity(vehicleDto);
            vehicle.setBrand(brand.get());
            vehicle.setId(id);

            return setServicesAndGetResponseDto(vehicleRepository.save(vehicle));
        } else {
            throw new EntityNotFoundException(MessageUtil.entityNotFound(id));
        }
    }

    @Override
    public VehicleResponseDto getById(Long id) {
        Vehicle vehicle = vehicleRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        return setServicesAndGetResponseDto(vehicle);
    }

    @Override
    public List<VehicleResponseDto> getAll() {
        return vehicleRepository
                .findAll()
                .stream()
                .map(this::setServicesAndGetResponseDto)
                .toList();
    }

    @Override
    public CustomPage<VehicleResponseDto> getByPage(Pageable pageable) {
        Page<VehicleResponseDto> page = vehicleRepository
                .findAll(pageable)
                .map(this::setServicesAndGetResponseDto);

        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            vehicleRepository.softDelete(id);
        } catch (Exception e) {
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }

    public Optional<Vehicle> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    private VehicleResponseDto setServicesAndGetResponseDto(Vehicle vehicle){
        var response = vehicleMapper.entityToDto(vehicle);
        response.setServices(getServicesForVehicle(vehicle));
        return response;
    }

    private List<ServicesForVehicleDto> getServicesForVehicle(Vehicle vehicle) {
        return vehicle.getServices()
                .stream()
                .map( e -> {
                    ServicesForVehicleDto service = servicesMapper.entityToServiceForVehicleDto(e);
                    service.setClient(clientMapper.entityToBasicDto(e.getClient()));
                    return service;
                })
                .toList();
    }
}
