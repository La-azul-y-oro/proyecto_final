package com.azulyoro.back.service;

import com.azulyoro.back.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements EntityService<Supplier, Supplier> {
    
    @Override
    public Supplier create(Supplier supplier) {
        return null;
    }

    @Override
    public Supplier update(Supplier supplier) {
        return null;
    }

    @Override
    public Supplier getById(Long id) {
        return null;
    }

    @Override
    public List<Supplier> getAll() {
        return List.of();
    }

    @Override
    public Page<Supplier> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }
}
