package com.azulyoro.back.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

interface EntityService<T, R>{
    R create(T t);
    R getById(Long id);
    List<R> getAll();
    Page<R> getByPage(Pageable pageable);
    Void delete(Long id);
}