package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.model.Service;
import com.azulyoro.back.model.ServiceType;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ServiceService implements EntityService<Service, ServiceType>{
    @Override
    public ServiceType create(Service service) {
        return null;
    }

    @Override
    public ServiceType update(Long id, Service service) {
        return null;
    }

    @Override
    public ServiceType getById(Long id) {
        return null;
    }

    @Override
    public List<ServiceType> getAll() {
        return List.of();
    }

    @Override
    public CustomPage<ServiceType> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
