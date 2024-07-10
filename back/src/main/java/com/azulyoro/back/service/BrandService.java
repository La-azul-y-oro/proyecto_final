package com.azulyoro.back.service;

import com.azulyoro.back.dto.BrandRequestDto;
import com.azulyoro.back.dto.BrandResponseDto;
import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.mapper.BrandMapper;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.model.Brand;
import com.azulyoro.back.repository.BrandRepository;
import com.azulyoro.back.util.MessageUtil;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements EntityService<BrandRequestDto, BrandResponseDto> {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public BrandResponseDto create(BrandRequestDto brandDto) {
        Brand brand = brandRepository.save(brandMapper.dtoToEntity(brandDto));
        return brandMapper.entityToDto(brand);
    }

    @Override
    public BrandResponseDto update(Long id, BrandRequestDto dto) {
        if(brandRepository.existsById(id)) {
            Brand brand = brandMapper.dtoToEntity(dto);
            brand.setId(id);

            Brand brandUpdated = brandRepository.save(brand);

            return brandMapper.entityToDto(brandUpdated);
        } else{
           throw new EntityNotFoundException(MessageUtil.entityNotFound(id));
        }
    }

    @Override
    public BrandResponseDto getById(Long id) {
        Brand brand = brandRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        return brandMapper.entityToDto(brand);
    }

    @Override
    public List<BrandResponseDto> getAll() {
        return brandRepository
                .findAll()
                .stream()
                .map(brandMapper::entityToDto)
                .toList();
    }

    @Override
    public CustomPage<BrandResponseDto> getByPage(Pageable pageable) {
        Page<BrandResponseDto> page = brandRepository
                .findAll(pageable)
                .map(brandMapper::entityToDto);

        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try{
            brandRepository.softDelete(id);
        }catch(Exception e){
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }
}
