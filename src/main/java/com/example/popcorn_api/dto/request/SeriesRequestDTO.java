package com.example.popcorn_api.dto.request;

import java.util.List;

import com.example.popcorn_api.models.Genres;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SeriesRequestDTO {
     @NotNull(message = "It's necessary to provide a title for the series")
  
    private String title;

    @NotNull(message = "It's necessary to provide a description for the series")

    private String description;

  
    private String poster;

  
    private List<Genres> genres;
    //

}
