package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.model.Brand;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements EntityService<Brand, Brand> {

    @Override
    public Brand create(Brand brand) {
        return null;
    }

    @Override
    public Brand update(Long id, Brand brand) {
        return null;
    }

    @Override
    public Brand getById(Long id) {
        return null;
    }

    @Override
    public List<Brand> getAll() {
        return List.of();
    }

    @Override
    public CustomPage<Brand> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {}
}
