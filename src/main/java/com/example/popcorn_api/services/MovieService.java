package com.example.popcorn_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.popcorn_api.dto.MovieDTO;
import com.example.popcorn_api.mapper.mapperIMPL.MovieMapper;
import com.example.popcorn_api.models.Movie;
import com.example.popcorn_api.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public void create(MovieDTO movieDto) {
        Movie movie = movieMapper.mapToEntity(movieDto);
        movieRepository.save(movie);
    }

}