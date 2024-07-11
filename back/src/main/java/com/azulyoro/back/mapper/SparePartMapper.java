package com.azulyoro.back.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azulyoro.back.dto.SparePartRequestDto;
import com.azulyoro.back.dto.SparePartResponseDto;
import com.azulyoro.back.model.SparePart;

@Component
public class SparePartMapper implements Mapper<SparePart, SparePartRequestDto, SparePartResponseDto>{
    
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public SparePartResponseDto entityToDto(SparePart sparePart){
        return SparePartResponseDto.builder()
                .id(sparePart.getId())
                .name(sparePart.getName())
                .brand(brandMapper.entityToDto(sparePart.getBrand()))
                .madeIn(sparePart.getMadeIn())
                .isDeleted(sparePart.isDeleted())
                .build();
    }

    @Override
    public SparePart dtoToEntity(SparePartRequestDto sparePartRequestDto){
        return SparePart.builder()  
                .name(sparePartRequestDto.getName())
                .madeIn(sparePartRequestDto.getMadeIn())
                .build();
    }
}
