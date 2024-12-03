package com.example.popcorn_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.popcorn_api.models.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long>{
    
}
