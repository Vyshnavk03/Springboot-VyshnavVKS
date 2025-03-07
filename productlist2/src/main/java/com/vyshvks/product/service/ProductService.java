package com.vyshvks.product.service;

import com.vyshvks.product.dto.ProductDTO;
import com.vyshvks.product.entity.Category;
import com.vyshvks.product.entity.Product;
import com.vyshvks.product.exception.CategoryNotFoundException;
import com.vyshvks.product.mapper.ProductMapper;
import com.vyshvks.product.repository.CategoryRepository;
import com.vyshvks.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {


    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category id: " +
                        productDTO.getCategoryId() + " not found!"));//where ever this exception is occur then global exception handler will invoke the method we return in that

        //DTO -> Entity

        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);

        // Entity -> DTO

        return ProductMapper.toProductDTO(product);
    }

    //get all product
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    //get by id
    public ProductDTO getProductById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produvt not Found!"));

        return ProductMapper.toProductDTO(product);
    }
    //update Product

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found!"));
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not Found!"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(product.getPrice());
        product.setCategory(category);
        productRepository.save(product);

        return ProductMapper.toProductDTO(product);

    }

    //delete
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);

        return "Product" + id + "has been deleted!";
    }
}
