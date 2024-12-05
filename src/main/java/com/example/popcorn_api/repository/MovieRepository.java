package com.example.popcorn_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.popcorn_api.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
