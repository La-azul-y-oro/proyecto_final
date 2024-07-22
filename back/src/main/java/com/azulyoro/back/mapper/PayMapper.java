package com.azulyoro.back.mapper;

import com.azulyoro.back.dto.request.PayRequestDto;
import com.azulyoro.back.dto.response.PayResponseDto;
import com.azulyoro.back.model.Pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayMapper implements Mapper <Pay, PayRequestDto, PayResponseDto>{

     @Autowired
     private PaymentTypeMapper paymentTypeMapper;

     @Override
    public PayResponseDto entityToDto(Pay pay){
         return PayResponseDto.builder()
                 .id(pay.getId())
                 .date(pay.getDate())
                 .paymentTypeResponseDto(paymentTypeMapper.entityToDto(pay.getPaymentType()))
                 .isDeleted(pay.isDeleted())
                 .build();
     }

     @Override
    public Pay dtoToEntity(PayRequestDto payDto){
         return Pay.builder()
                 .date(payDto.getDate())
                 .build();
     }

}
