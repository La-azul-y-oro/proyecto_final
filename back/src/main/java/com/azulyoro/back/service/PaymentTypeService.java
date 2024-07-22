package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.PaymentTypeRequestDto;
import com.azulyoro.back.dto.response.PaymentTypeResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.mapper.PaymentTypeMapper;
import com.azulyoro.back.model.PaymentType;
import com.azulyoro.back.repository.PaymentTypeRepository;
import com.azulyoro.back.util.MessageUtil;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeService implements EntityService<PaymentTypeRequestDto, PaymentTypeResponseDto>{

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private PaymentTypeMapper paymentTypeMapper;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public PaymentTypeResponseDto create(PaymentTypeRequestDto paymenttypeDto) {
        PaymentType paymenttype = paymentTypeRepository.save(paymentTypeMapper.dtoToEntity(paymenttypeDto));
        return paymentTypeMapper.entityToDto(paymenttype);
    }

    @Override
    public PaymentTypeResponseDto update(Long id, PaymentTypeRequestDto dto) {
        if(paymentTypeRepository.existsById(id)) {
            PaymentType paymenttype = paymentTypeMapper.dtoToEntity(dto);
            paymenttype.setId(id);

            PaymentType paymenttypeUpdated = paymentTypeRepository.save(paymenttype);

            return paymentTypeMapper.entityToDto(paymenttypeUpdated);
        } else {
            throw new EntityNotFoundException(MessageUtil.entityNotFound(id));
        }
    }

    @Override
    public PaymentTypeResponseDto getById(Long id) {
        PaymentType paymentyype = paymentTypeRepository
                    .findById(id)
                    .orElseThrow(()->new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        return paymentTypeMapper.entityToDto(paymentyype);
    }

    @Override
    public List<PaymentTypeResponseDto> getAll() {
        return paymentTypeRepository
                .findAll()
                .stream()
                .map(paymentTypeMapper::entityToDto)
                .toList();
    }

    @Override
    public CustomPage<PaymentTypeResponseDto> getByPage(Pageable pageable) {
        Page<PaymentTypeResponseDto> page = paymentTypeRepository
                .findAll(pageable)
                .map(paymentTypeMapper::entityToDto);

        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            paymentTypeRepository.softDelete(id);
        } catch (Exception e) {
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }
}
