package com.azulyoro.back.service;

import com.azulyoro.back.model.PaymentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeService implements EntityService<PaymentType, PaymentType>{
    @Override
    public PaymentType create(PaymentType paymentType) {
        return null;
    }

    @Override
    public PaymentType getById(Long id) {
        return null;
    }

    @Override
    public List<PaymentType> getAll() {
        return null;
    }

    @Override
    public Page<PaymentType> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }
}
