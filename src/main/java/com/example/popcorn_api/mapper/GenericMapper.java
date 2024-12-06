package com.example.popcorn_api.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenericMapper<T, P> {
    T mapToEntity(P dto);
    P mapToDTO(T entity);
}
