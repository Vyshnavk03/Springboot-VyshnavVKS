package com.vyshvks.product.service;

import com.vyshvks.product.dto.CategoryDTO;
import com.vyshvks.product.entity.Category;
import com.vyshvks.product.mapper.CategoryMapper;
import com.vyshvks.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {


    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    //get all category
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    //get category by id
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
        return CategoryMapper.toCategoryDTO(category);
    }

    //delete
    public String deleteCategory(@PathVariable long id) {
        categoryRepository.deleteById(id);
        return "Category" + id + " has been deleted!";
    }

}
