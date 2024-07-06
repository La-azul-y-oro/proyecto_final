package com.azulyoro.back.service;

import com.azulyoro.back.model.TypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class TypeServiceService implements EntityService<TypeService, TypeService>{

    @Override
    public TypeService create(TypeService typeService) {
        return null;
    }

    @Override
    public TypeService getById(Long id) {
        return null;
    }

    @Override
    public List<TypeService> getAll() {
        return List.of();
    }

    @Override
    public Page<TypeService> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }
}
