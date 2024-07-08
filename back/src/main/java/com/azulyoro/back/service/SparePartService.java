package com.azulyoro.back.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azulyoro.back.model.SparePart;

@Service
public class SparePartService implements EntityService<SparePart, SparePart> {
    @Override
    public SparePart create(SparePart sparePart) {
        return null;
    }

    @Override
    public SparePart update(SparePart sparePart) {
        return null;
    }

    @Override
    public SparePart getById(Long id) {
        return null;
    }

    @Override
    public List<SparePart> getAll() {
        return List.of();
    }

    @Override
    public Page<SparePart> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }
}
