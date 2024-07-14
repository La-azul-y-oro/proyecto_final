package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.InventoryRequestDto;
import com.azulyoro.back.dto.InventoryResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.exception.EntityNotFoundOrInactiveException;
import com.azulyoro.back.mapper.InventoryMapper;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.model.Inventory;
import com.azulyoro.back.model.SparePart;
import com.azulyoro.back.model.Supplier;
import com.azulyoro.back.repository.InventoryRepository;
import com.azulyoro.back.util.MessageUtil;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService implements EntityService <InventoryRequestDto, InventoryResponseDto> {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private PageMapper pageMapper;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SparePartService sparePartService;

    @Override
    public InventoryResponseDto create(InventoryRequestDto inventoryDto) {
        Optional<Supplier> supplier = supplierService.getSupplierEntity(inventoryDto.getSupplierId());
        Optional<SparePart> sparePart = sparePartService.getSparePartEntity(inventoryDto.getSparePartId());

        if (supplier.isEmpty() || supplier.get().isDeleted()) {
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(inventoryDto.getSupplierId()));
        }

        if (sparePart.isEmpty() || sparePart.get().isDeleted()) {
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(inventoryDto.getSparePartId()));
        }

        Inventory inventory = inventoryMapper.dtoToEntity(inventoryDto);
        inventory.setSupplier(supplier.get());
        inventory.setSparePart(sparePart.get());

        inventory = inventoryRepository.save(inventory);

        return inventoryMapper.entityToDto(inventory);
    }

    @Override
    public InventoryResponseDto update(Long id, InventoryRequestDto inventoryDto) {
        Optional<Supplier> supplier = supplierService.getSupplierEntity(inventoryDto.getSupplierId());
        Optional<SparePart> sparePart = sparePartService.getSparePartEntity(inventoryDto.getSparePartId());

        if (supplier.isEmpty() || supplier.get().isDeleted()) {
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(inventoryDto.getSupplierId()));
        }

        if (sparePart.isEmpty() || sparePart.get().isDeleted()) {
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(inventoryDto.getSparePartId()));
        }

        if (inventoryRepository.existsById(id)) {
            Inventory inventory = inventoryMapper.dtoToEntity(inventoryDto);
            inventory.setSupplier(supplier.get());
            inventory.setSparePart(sparePart.get());
            inventory.setId(id);

            Inventory inventoryUpdated = inventoryRepository.save(inventory);

            return inventoryMapper.entityToDto(inventoryUpdated);
        } else {
            throw new EntityNotFoundException(MessageUtil.entityNotFound(id));
        }
    }

    @Override
    public InventoryResponseDto getById(Long id) {
        Inventory inventory = inventoryRepository
                    .findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        return inventoryMapper.entityToDto(inventory);
    }

    @Override
    public List<InventoryResponseDto> getAll() {
        return inventoryRepository
                    .findAll()
                    .stream()
                    .map(inventoryMapper::entityToDto)
                    .toList();
    }

    @Override
    public CustomPage<InventoryResponseDto> getByPage(Pageable pageable) {
        Page<InventoryResponseDto> page = inventoryRepository
                .findAll(pageable)
                .map(inventoryMapper::entityToDto);

        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            inventoryRepository.softDelete(id);
        } catch (Exception e) {
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }
}
