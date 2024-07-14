package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.model.Services;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService implements EntityService<Services, Services> {

    @Override
    public Services create(Services service) {
        return null;
    }

    @Override
    public Services update(Long id, Services service) {
        return null;
    }

    @Override
    public Services getById(Long id) {
        return null;
    }

    @Override
    public List<Services> getAll() {
        return null;
    }

    @Override
    public CustomPage<Services> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
