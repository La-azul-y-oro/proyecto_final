package com.azulyoro.back.services;

import org.springframework.data.domain.Pageable;

import java.util.List;

interface EntityService<T, R>{
    R create(T t);
    R getById(Long id);
    R getAll();
    List<R> getByPage(Pageable pageable);
    Void delete(Long id);
}