package com.example.popcorn_api.dto;

import java.util.List;

public record MovieDTO(
    Long id,
    String title,
    Boolean adult,
    String backdrop_path,
    List<Integer> genre_ids,
    String original_language,
    String original_title,
    String overview,
    Double popularity,
    String poster_path,
    String release_date,
    Boolean video,
    Double vote_average,
    Integer vote_count,
    Integer runtime,
    List<GenresDTO> genres
) {}
