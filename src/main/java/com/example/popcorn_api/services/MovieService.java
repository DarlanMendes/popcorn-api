package com.example.popcorn_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.popcorn_api.models.Movie;
import com.example.popcorn_api.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}