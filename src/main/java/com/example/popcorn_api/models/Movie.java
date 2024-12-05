package com.example.popcorn_api.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="It's necessary title for movie creation")
    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private Boolean adult;

    @Column(nullable=false)
    private String backdrop_path;

    @Column(nullable=false)
    private List<Integer> genre_ids;

    @Column(nullable=false)
    private String original_language;

    @Column(nullable=false)
    private String original_title;

    @Column(nullable=false)
    private String overview;

    @Column(nullable=false)
    private Double popularity;

    @Column(nullable=false)
    private String poster_path;

    @Column(nullable=false)
    private String release_date; 

    @Column(nullable=false)
    private Boolean video;

    @Column(nullable=false)
    private Double vote_average;

    @Column(nullable=false)
    private Integer vote_count;

    @Column(nullable=false)
    private Integer runtime;

    @Column(nullable=false)
    @ManyToMany(mappedBy="movies" , cascade= CascadeType.ALL)
    private List<Genres>genres;
}
