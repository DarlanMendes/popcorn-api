package com.example.popcorn_api.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Series {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull(message = "It's necessary to provide a title for the series")
    @Column(nullable = false, unique = true)
    private String title;

    @NotNull(message = "It's necessary to provide a description for the series")
    @Column(nullable = false)
    private String description;

    @Column(name = "POSTER")
    private String poster;

    @ManyToMany
    private List<Genres> genres;
    //

}
