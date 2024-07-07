package com.azulyoro.back.service;

import com.azulyoro.back.model.Pay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayService implements EntityService<Pay, Pay>{

    @Override
    public Pay create(Pay pay) {
        return null;
    }

    @Override
    public Pay update(Pay pay) {
        return null;
    }

    @Override
    public Pay getById(Long id) {
        return null;
    }

    @Override
    public List<Pay> getAll() {
        return List.of();
    }

    @Override
    public Page<Pay> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }
}
