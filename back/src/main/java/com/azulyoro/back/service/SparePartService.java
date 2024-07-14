package com.azulyoro.back.service;

import java.util.List;
import java.util.Optional;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.SparePartRequestDto;
import com.azulyoro.back.dto.SparePartResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.mapper.SparePartMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azulyoro.back.model.Brand;
import com.azulyoro.back.model.SparePart;
import com.azulyoro.back.model.Supplier;
import com.azulyoro.back.repository.BrandRepository;
import com.azulyoro.back.repository.SparePartRepository;
import com.azulyoro.back.util.MessageUtil;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class SparePartService implements EntityService<SparePartRequestDto, SparePartResponseDto> {
    @Autowired
    private SparePartRepository sparePartRepository;
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private SparePartMapper sparePartMapper;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public SparePartResponseDto create(SparePartRequestDto sparePartDto) {
        Brand brand = brandRepository.findById(sparePartDto.getBrandId())
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.entityNotFound(sparePartDto.getBrandId())));

        SparePart sparePart = sparePartMapper.dtoToEntity(sparePartDto);
        sparePart.setBrand(brand);

        return sparePartMapper.entityToDto(sparePartRepository.save(sparePart));
    }

    @Override
    public SparePartResponseDto update(Long id, SparePartRequestDto dto) {
        Brand brand = brandRepository.findById(dto.getBrandId())
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.entityNotFound(dto.getBrandId())));
                
        if(sparePartRepository.existsById(id)) {
            SparePart sparePart = sparePartMapper.dtoToEntity(dto);
            sparePart.setId(id);
            sparePart.setBrand(brand);

            return sparePartMapper.entityToDto(sparePartRepository.save(sparePart));
        }else {
           throw new EntityNotFoundException(MessageUtil.entityNotFound(id));
        }
    }

    @Override
    public SparePartResponseDto getById(Long id) {
        SparePart sparePart = sparePartRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        return sparePartMapper.entityToDto(sparePart);
    }

    @Override
    public List<SparePartResponseDto> getAll() {
        return sparePartRepository
                .findAll()
                .stream()
                .map(sparePartMapper::entityToDto)
                .toList();
    }

    @Override
    public CustomPage<SparePartResponseDto> getByPage(Pageable pageable) {
        Page<SparePartResponseDto> page = sparePartRepository
                .findAll(pageable)
                .map(sparePartMapper::entityToDto);

        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try{
            sparePartRepository.softDelete(id);
        }catch(Exception e){
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }

    public Optional<SparePart> getSparePartEntity(Long id) {
        Optional<SparePart> sparePart = sparePartRepository.findById(id);

        return sparePart;
    }
}
