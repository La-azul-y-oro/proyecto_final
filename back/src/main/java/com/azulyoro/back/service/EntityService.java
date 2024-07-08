package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EntityService<T, R>{
    R create(T t);
    R update(Long id, T t);
    R getById(Long id);
    List<R> getAll();
    CustomPage<R> getByPage(Pageable pageable);
    void delete(Long id);
}