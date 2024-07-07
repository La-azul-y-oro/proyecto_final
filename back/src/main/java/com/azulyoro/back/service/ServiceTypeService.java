package com.azulyoro.back.service;

import com.azulyoro.back.model.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements EntityService<ServiceType, ServiceType>{

    @Override
    public ServiceType create(ServiceType typeService) {
        return null;
    }

    @Override
    public ServiceType update(ServiceType serviceType) {
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
    public Page<ServiceType> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }
}
