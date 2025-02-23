package com.vyshvks.product.mapper;

import com.vyshvks.product.dto.CategoryDTO;
import com.vyshvks.product.entity.Category;

public class CategoryMapper {

    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return  category;
    }

    public static CategoryDTO toCategoryDTO(Category category){
        if(category == null){
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(categoryDTO.getName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO)
                .toList());
        return CategoryDTO;
    }
}
