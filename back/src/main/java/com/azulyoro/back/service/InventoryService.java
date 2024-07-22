package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.InventoryRequestDto;
import com.azulyoro.back.dto.response.InventoryResponseDto;
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
        Supplier supplier = validateSupplier(inventoryDto.getSupplierId());
        SparePart sparePart = validateSparePart(inventoryDto.getSparePartId());

        Inventory inventory = inventoryMapper.dtoToEntity(inventoryDto);
        inventory.setSupplier(supplier);
        inventory.setSparePart(sparePart);

        inventory = inventoryRepository.save(inventory);

        return inventoryMapper.entityToDto(inventory);
    }

    @Override
    public InventoryResponseDto update(Long id, InventoryRequestDto inventoryDto) {
        Supplier supplier = validateSupplier(inventoryDto.getSupplierId());
        SparePart sparePart = validateSparePart(inventoryDto.getSparePartId());

        if (inventoryRepository.existsById(id)) {
            Inventory inventory = inventoryMapper.dtoToEntity(inventoryDto);
            inventory.setSupplier(supplier);
            inventory.setSparePart(sparePart);
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

    private Supplier validateSupplier(Long supplierId) {
        Optional<Supplier> supplier = supplierService.getSupplierEntity(supplierId);
        if (supplier.isEmpty() || supplier.get().isDeleted()) {
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(supplierId));
        }
        return supplier.get();
    }

    private SparePart validateSparePart(Long sparePartId) {
        Optional<SparePart> sparePart = sparePartService.findById(sparePartId);
        if (sparePart.isEmpty() || sparePart.get().isDeleted()) {
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(sparePartId));
        }
        return sparePart.get();
    }
}
