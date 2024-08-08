package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.SupplierRequestDto;
import com.azulyoro.back.dto.response.SupplierResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.mapper.SupplierMapper;
import com.azulyoro.back.model.Supplier;
import com.azulyoro.back.repository.SupplierRepository;
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
public class SupplierService implements EntityService<SupplierRequestDto, SupplierResponseDto> {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public SupplierResponseDto create(SupplierRequestDto supplierDto) {
        Supplier supplier = supplierRepository.save(supplierMapper.dtoToEntity(supplierDto));
        return supplierMapper.entityToDto(supplier);
    }

    @Override
    public SupplierResponseDto update(Long id, SupplierRequestDto dto) {
        if(supplierRepository.existsById(id)) {
            Supplier supplier = supplierMapper.dtoToEntity(dto);
            supplier.setId(id);

            Supplier supplierUpdated = supplierRepository.save(supplier);

            return supplierMapper.entityToDto(supplierUpdated);
        }else{
           throw new EntityNotFoundException(MessageUtil.entityNotFound(id));
        }
    }

    @Override
    public SupplierResponseDto getById(Long id) {
        Supplier supplier = supplierRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        return supplierMapper.entityToDto(supplier);
    }

    @Override
    public List<SupplierResponseDto> getAll() {
        return supplierRepository
                .findAll()
                .stream()
                .map(supplierMapper::entityToDto)
                .toList();
    }

    @Override
    public CustomPage<SupplierResponseDto> getByPage(Pageable pageable) {
        Page<SupplierResponseDto> page = supplierRepository
                .findAll(pageable)
                .map(supplierMapper::entityToDto);

        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try{
            supplierRepository.softDelete(id);
        }catch(Exception e){
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }

    public Optional<Supplier> getSupplierEntity(Long id) {
        return supplierRepository.findById(id);
    }
}
