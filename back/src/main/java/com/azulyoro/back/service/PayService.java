package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.model.Pay;
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
    public Pay update(Long id, Pay pay) {
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
    public CustomPage<Pay> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {}
}
