package com.example.popcorn_api.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.popcorn_api.exceptions.CategoryException;
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
                return categoriesRepository.findById(id).orElseThrow(()-> new CategoryException("Category not found for id:"+id));       
    }
    public Categories create(Categories  category){
        return categoriesRepository.save(category);
    }
    public Categories update(Long id, String name){
            Categories categories = this.findCategoryById(id);
            categories.setName(name);
            return categoriesRepository.save(categories); 
    }
    public void  deleteCategory(Long id){
        
            Categories category = this.findCategoryById(id);
            categoriesRepository.delete(category);
        
    }
  
}
