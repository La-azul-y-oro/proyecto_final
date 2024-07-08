package com.azulyoro.back.mapper;

import com.azulyoro.back.dto.SupplierRequestDto;
import com.azulyoro.back.dto.SupplierResponseDto;
import com.azulyoro.back.model.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper implements Mapper<Supplier, SupplierRequestDto, SupplierResponseDto> {

    @Override
    public SupplierResponseDto entityToDto(Supplier supplier){
        return SupplierResponseDto.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .address(supplier.getAddress())
                .phone(supplier.getPhone())
                .email(supplier.getEmail())
                .isDeleted(supplier.isDeleted())
                .build();
    }

    @Override
    public Supplier dtoToEntity(SupplierRequestDto supplierRequestDto){
        return Supplier.builder()
                .name(supplierRequestDto.getName())
                .address(supplierRequestDto.getAddress())
                .phone(supplierRequestDto.getPhone())
                .email(supplierRequestDto.getEmail())
                .build();
    }
}
