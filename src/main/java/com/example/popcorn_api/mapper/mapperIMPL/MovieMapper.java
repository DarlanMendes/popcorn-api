package com.example.popcorn_api.mapper.mapperIMPL;

import org.mapstruct.Mapper;

import com.example.popcorn_api.dto.MovieDTO;
import com.example.popcorn_api.mapper.GenericMapper;
import com.example.popcorn_api.models.Movie;

@Mapper(componentModel = "spring")
public interface MovieMapper extends GenericMapper<Movie, MovieDTO> {

}
