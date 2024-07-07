package com.azulyoro.back.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.azulyoro.back.model.Vehicle;

@Service
public class VehicleService implements EntityService<Vehicle, Vehicle> {

    @Override
    public Vehicle create(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle getById(Long id) {
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        return List.of();
    }

    @Override
    public Page<Vehicle> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

}
