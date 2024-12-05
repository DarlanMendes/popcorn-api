package com.example.popcorn_api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDTO {
    @NotNull(message = "Name can't be null")
    @NotEmpty(message = "Name field can't be empty")
    private String name;
}
