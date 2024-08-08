package com.azulyoro.back.service;


import com.azulyoro.back.model.ServiceStatus;
import com.azulyoro.back.model.Services;
import com.azulyoro.back.repository.ServicesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.PayRequestDto;
import com.azulyoro.back.dto.response.PayResponseDto;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.exception.EntityNotFoundOrInactiveException;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.mapper.PayMapper;
import com.azulyoro.back.model.Pay;
import com.azulyoro.back.model.PaymentType;
import com.azulyoro.back.repository.PayRepository;
import com.azulyoro.back.repository.PaymentTypeRepository;
import com.azulyoro.back.util.MessageUtil;

import java.util.List;
import java.util.Optional;

@Service
public class PayService implements EntityService<PayRequestDto, PayResponseDto>{

    @Autowired
    private PayRepository payRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private PayMapper payMapper;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public PayResponseDto create(PayRequestDto payDto) {
        validateServices(payDto.getServiceIds());
        Pay pay = payMapper.dtoToEntity(payDto);
        pay.setPaymentType(getAndValidatePaymentType(payDto.getPaymentTypeId()));
        return payMapper.entityToDto(payRepository.save(pay));
    }

    @Override
    public PayResponseDto update(Long id, PayRequestDto dto) {
        validateServices(dto.getServiceIds());
        if(payRepository.existsById(id)){
            Pay pay = payMapper.dtoToEntity(dto);
            pay.setId(id);
            pay.setPaymentType(getAndValidatePaymentType(dto.getPaymentTypeId()));
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
            Pay pay = payRepository.findById(id).get();
            pay.getServices();
            payRepository.softDelete(id);
        }catch(Exception e){
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }

    private PaymentType getAndValidatePaymentType(Long id){

        Optional<PaymentType> paymentType2 = paymentTypeRepository.findById(id);

        if (paymentType2.isEmpty() || paymentType2.get().isDeleted()){
            throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(id));
        }
        return paymentType2.get();
    }

    private void validateServices(List<Long> servicesIds){
        for (Long servicesId : servicesIds){
            Services service = servicesRepository.findById(servicesId)
                    .orElseThrow(() -> new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(servicesId)));

            if(service.getStatus() == ServiceStatus.CANCELLED){
                throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(servicesId));
            }
            /*TODO
                El pago ya asociado va a traer conflictos en el update, ajustar luego
                if(service.getPay() != null){
                throw new EntityNotFoundOrInactiveException(MessageUtil.entityNotFoundOrInactive(servicesId));
            }
            */
        }
    }

}
