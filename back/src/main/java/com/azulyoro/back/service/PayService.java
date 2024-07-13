package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.PayRequestDto;
import com.azulyoro.back.dto.PayResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.mapper.PayMapper;
import com.azulyoro.back.model.Pay;
import com.azulyoro.back.model.PaymentType;
import com.azulyoro.back.repository.PayRepository;
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
public class PayService implements EntityService<PayRequestDto, PayResponseDto>{

    @Autowired
    private PayRepository payRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private PayMapper payMapper;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public PayResponseDto create(PayRequestDto payDto) {

        PaymentType paymentType = paymentTypeRepository.findById(payDto.getPaymentTypeId())
                .orElseThrow(()-> new EntityNotFoundException(MessageUtil.entityNotFound(payDto.getPaymentTypeId())));

        Pay pay = payMapper.dtoToEntity(payDto);
        pay.setPaymentType(paymentType);

        return payMapper.entityToDto(payRepository.save(pay));
    }

    @Override
    public PayResponseDto update(Long id, PayRequestDto dto) {

        PaymentType paymentType = paymentTypeRepository.findById(dto.getPaymentTypeId())
                .orElseThrow(()-> new EntityNotFoundException(MessageUtil.entityNotFound(dto.getPaymentTypeId())));

        if(payRepository.existsById(id)){
            Pay pay = payMapper.dtoToEntity(dto);
            pay.setId(id);
            pay.setPaymentType(paymentType);

            return payMapper.entityToDto(payRepository.save(pay));
        }else{

            throw new EntityNotFoundException(MessageUtil.entityNotFound(id));

        }
    }

    @Override
    public PayResponseDto getById(Long id) {

        Pay pay = payRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(MessageUtil.entityNotFound(id)));

        return payMapper.entityToDto(pay);
    }

    @Override
    public List<PayResponseDto> getAll() {
        return payRepository
                .findAll()
                .stream()
                .map(payMapper::entityToDto)
                .toList();
    }

    @Override
    public CustomPage<PayResponseDto> getByPage(Pageable pageable) {
        Page<PayResponseDto> page = payRepository
                .findAll(pageable)
                .map(payMapper::entityToDto);
        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try{
            payRepository.softDelete(id);
        }catch(Exception e){
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }
}
