package com.azulyoro.back.service;

import java.util.List;

import com.azulyoro.back.dto.CustomPage;
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
    public SparePart update(Long id, SparePart sparePart) {
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
    public CustomPage<SparePart> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {}
}
