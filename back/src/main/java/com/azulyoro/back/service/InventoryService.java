package com.azulyoro.back.service;

import com.azulyoro.back.model.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService implements EntityService <Inventory, Inventory> {

    @Override
    public Inventory create(Inventory inventory) {
        return null;
    }

    @Override
    public Inventory update(Inventory inventory) {
        return null;
    }

    @Override
    public Inventory getById(Long id) {
        return null;
    }

    @Override
    public List<Inventory> getAll() {
        return List.of();
    }

    @Override
    public Page<Inventory> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }
}
