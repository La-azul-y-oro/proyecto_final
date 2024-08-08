package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.ServiceTypeRequestDto;
import com.azulyoro.back.dto.response.ServiceTypeResponseDto;
import com.azulyoro.back.exception.CannotDeleteActiveServicesException;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.mapper.ServiceTypeMapper;
import com.azulyoro.back.model.ServiceType;
import com.azulyoro.back.repository.ServiceTypeRepository;
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
public class ServiceTypeService implements EntityService<ServiceTypeRequestDto, ServiceTypeResponseDto> {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private ServiceTypeMapper serviceTypeMapper;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public ServiceTypeResponseDto create(ServiceTypeRequestDto typeServiceDto) {
        ServiceType serviceType = serviceTypeRepository.save(serviceTypeMapper.dtoToEntity(typeServiceDto));
        return serviceTypeMapper.entityToDto(serviceType);
    }

    @Override
    public ServiceTypeResponseDto update(Long id, ServiceTypeRequestDto dto) {
        if (serviceTypeRepository.existsById(id)) {
            ServiceType serviceType = serviceTypeMapper.dtoToEntity(dto);
            serviceType.setId(id);

            ServiceType serviceTypeUpdated = serviceTypeRepository.save(serviceType);
            return serviceTypeMapper.entityToDto(serviceTypeUpdated);
        } else {
           throw new EntityNotFoundException(MessageUtil.entityNotFound(id));
        }
    }

    @Override
    public ServiceTypeResponseDto getById(Long id) {
        ServiceType serviceType = serviceTypeRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        return serviceTypeMapper.entityToDto(serviceType);
    }

    @Override
    public List<ServiceTypeResponseDto> getAll() {
        return serviceTypeRepository
                .findAll()
                .stream()
                .map(serviceTypeMapper::entityToDto)
                .toList();
    }

    @Override
    public CustomPage<ServiceTypeResponseDto> getByPage(Pageable pageable) {
        Page<ServiceTypeResponseDto> page = serviceTypeRepository
                .findAll(pageable)
                .map(serviceTypeMapper::entityToDto);

        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        long activeServicesCount = serviceTypeRepository.countActiveServices(id);

        if (activeServicesCount > 0) {
            throw new CannotDeleteActiveServicesException(MessageUtil.entityRelatedCannotDelete(id));
        }

        try {
            serviceTypeRepository.softDelete(id);
        } catch (Exception e) {
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }

    public Optional<ServiceType> findById(Long id) {
        return serviceTypeRepository.findById(id);
    }
}