package com.azulyoro.back.mapper;

import org.springframework.stereotype.Component;

import com.azulyoro.back.dto.request.PaymentTypeRequestDto;
import com.azulyoro.back.dto.response.PaymentTypeResponseDto;
import com.azulyoro.back.model.PaymentType;

@Component
public class PaymentTypeMapper implements Mapper <PaymentType, PaymentTypeRequestDto , PaymentTypeResponseDto> {

    @Override
    public PaymentTypeResponseDto entityToDto(PaymentType paymentType) {
        return PaymentTypeResponseDto.builder()
            .isDeleted(paymentType.isDeleted())
            .category(paymentType.getCategory())
            .name(paymentType.getName())
            .id(paymentType.getId())
            .build();
    }

    @Override
    public PaymentType dtoToEntity(PaymentTypeRequestDto dto) {
        return PaymentType.builder()
            .name(dto.getName())
            .category(dto.getCategory())
            .build();
    }
}