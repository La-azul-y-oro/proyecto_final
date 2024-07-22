package com.azulyoro.back.mapper;

import org.springframework.stereotype.Component;

import com.azulyoro.back.dto.request.BrandRequestDto;
import com.azulyoro.back.dto.response.BrandResponseDto;
import com.azulyoro.back.model.Brand;

@Component
public class BrandMapper implements Mapper<Brand, BrandRequestDto, BrandResponseDto> {

    @Override
    public BrandResponseDto entityToDto(Brand brand){
        return BrandResponseDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .category(brand.getCategory())
                .isDeleted(brand.isDeleted())
                .build();
    }

    @Override
    public Brand dtoToEntity(BrandRequestDto brandRequestDto){
        return Brand.builder()
                .name(brandRequestDto.getName())
                .category(brandRequestDto.getCategory())
                .build();
    }
}
