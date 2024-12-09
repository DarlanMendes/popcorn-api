package com.example.popcorn_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.popcorn_api.models.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, UUID> {
    //
}
