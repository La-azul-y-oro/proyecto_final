package com.azulyoro.back.mapper;

/**
 * @param <E> Entity
 * @param <T> RequestDto
 * @param <R> ResponseDto
 */
public interface Mapper <E, T, R>{
    R entityToDto(E e);
    E dtoToEntity(T i);
}
