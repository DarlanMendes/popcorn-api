package com.example.popcorn_api.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
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

    @ManyToMany(mappedBy = "genres")
    private List<Genres> genres;

}
