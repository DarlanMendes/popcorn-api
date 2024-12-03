package com.example.popcorn_api.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.popcorn_api.exceptions.CategoryNotFoundException;
import com.example.popcorn_api.models.Categories;
import com.example.popcorn_api.repository.CategoriesRepository;

@Service
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;
    public CategoriesService(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }
    public List<Categories> findAllCategories(){
        return categoriesRepository.findAll();
    }
    public Categories findCategoryById(Long id){   
                return this.categoriesRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category not found for id:"+id));       
    }
    public void create(Categories  category){
        categoriesRepository.save(category);
    }
    public void deleteCategory(Categories category){
         categoriesRepository.delete(category);
    }
}
