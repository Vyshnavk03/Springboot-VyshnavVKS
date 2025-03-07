package com.vyshvks.product.controller;

import com.vyshvks.product.dto.CategoryDTO;
import com.vyshvks.product.exception.CategoryAlreadyExistsException;
import com.vyshvks.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    //create categories
    @PostMapping
    public ResponseEntity<?> createCategory(CategoryDTO categoryDTO) {// here we specified ? generic so that in try it return catogery and in catch block it return string so it will have confilit in return type so has genric it can be any when dto it will dto and when string it will act has string
        CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

//        // try and catch is excluded because if we are creating like this for each controller it will be big problem to handle the code so we introduce the global exception which handle it when exception occurs
//        try {
//            CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//        } catch (CategoryAlreadyExistsException ex) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//        }
        // this below statement was before exception class created
        //return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    // get all categories
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //get category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    //delete

    @DeleteMapping
    public String deleteCategory(@PathVariable long id) {
        return categoryService.deleteCategory(id);
    }
}
