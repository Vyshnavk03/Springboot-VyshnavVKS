package com.vyshvks.product.service;

import com.vyshvks.product.dto.CategoryDTO;
import com.vyshvks.product.entity.Category;
import com.vyshvks.product.mapper.CategoryMapper;
import com.vyshvks.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return  CategoryMapper.toCategoryDTO(category);
    }
}
