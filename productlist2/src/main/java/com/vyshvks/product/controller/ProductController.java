package com.vyshvks.product.controller;

import com.vyshvks.product.dto.ProductDTO;
import com.vyshvks.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    //create product
    @PostMapping()
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    //get all product
    @GetMapping
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProducts();
    }

    //get product by id
    @GetMapping("/{id}")
    public ProductDTO getAllProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //update
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }

}
