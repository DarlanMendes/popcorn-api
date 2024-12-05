package com.example.popcorn_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.popcorn_api.dto.CategoryDTO;
import com.example.popcorn_api.exceptions.CategoryException;
import com.example.popcorn_api.models.Categories;
import com.example.popcorn_api.services.CategoriesService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
        }catch(CategoryException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
       
    }
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryDTO  categoryDTO) {
        Categories category = new Categories();
        
        category.setName(categoryDTO.getName());
        try{
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriesService.create(category));
        }catch(Exception e){
           
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
       
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid CategoryDTO categoryDTO){
            try{
                Categories updatedCategory = categoriesService.update(id, categoryDTO.getName());
            return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
            }catch(Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try{
            
            categoriesService.deleteCategory(id);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }catch(CategoryException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
        
    }
    
    
}
