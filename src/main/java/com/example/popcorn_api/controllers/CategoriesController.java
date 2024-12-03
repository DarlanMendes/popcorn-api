package com.example.popcorn_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.popcorn_api.dto.CategoryDTO;
import com.example.popcorn_api.exceptions.CategoryNotFoundException;
import com.example.popcorn_api.models.Categories;
import com.example.popcorn_api.services.CategoriesService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;






@RestController
@RequestMapping("/category")
public class CategoriesController {

    private final CategoriesService categoriesService;
    public CategoriesController(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategory() {
        return ResponseEntity.ok(categoriesService.findAllCategories());
    }
    
    @GetMapping("/{id}")
    private ResponseEntity<?>getCategory(@PathVariable Long id) {
        try{
            return  ResponseEntity.ok(categoriesService.findCategoryById(id));
        }catch(CategoryNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
       
    }
    @PostMapping
    public void createCategory(@RequestBody CategoryDTO  categoryDTO) {
        Categories category = new Categories();
        category.setName(categoryDTO.getName());
        categoriesService.create(category);
        
       
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try{
            Categories category = categoriesService.findCategoryById(id);
            categoriesService.deleteCategory(category);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }catch(CategoryNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
        
    }
    
    
}
