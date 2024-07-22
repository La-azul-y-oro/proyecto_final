package com.azulyoro.back.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azulyoro.back.dto.request.InventoryRequestDto;
import com.azulyoro.back.dto.response.InventoryResponseDto;
import com.azulyoro.back.model.Inventory;

@Component
public class InventoryMapper implements Mapper<Inventory, InventoryRequestDto, InventoryResponseDto> {
    
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private SparePartMapper sparePartMapper;

    @Override
    public InventoryResponseDto entityToDto(Inventory inventory) {
        return InventoryResponseDto.builder()
            .id(inventory.getId())
            .amount(inventory.getAmount())
            .supplier(supplierMapper.entityToDto(inventory.getSupplier()))
            .costPrice(inventory.getCostPrice())
            .salePrice(inventory.getSalePrice())
            .sparePart(sparePartMapper.entityToDto(inventory.getSparePart()))
            .build();
    }

    @Override
    public Inventory dtoToEntity(InventoryRequestDto dto) {
        return Inventory.builder()
            .amount(dto.getAmount())
            .costPrice(dto.getCostPrice())
            .salePrice(dto.getSalePrice())
            .build();
    } 
}
