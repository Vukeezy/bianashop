package com.example.webshop.mappers;

import java.util.List;

public interface MapperInterface<T, U> {

    T toEntity(U dto);
    U toDTO(T entity);
    List<T> toEntityList(List<U> dtos);
    List<U> toDTOList(List<T> entities);
}