package com.vyshvks.product.controller;

import com.vyshvks.product.dto.ProductDTO;
import com.vyshvks.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product REST API CURD Operation",
        description = "CREAT, READ, UPDATE AND  DELETE operations for Product REST API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    //create product
    //the operation annotation is the part of swagger
    @Operation(
            summary = "post the Product in database",
            description = "REST API to upload the product in database"
    )

    //this one too belong to swagger
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )

    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping()
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    //get all product
    //the operation annotation is the part of swagger
    @Operation(
            summary = "Fetch the product List in database",
            description = "REST API to fetch the product in database"
    )
    @GetMapping
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProducts();
    }

    //get product by id
    //the operation annotation is the part of swagger
    @Operation(
            summary = "Fetch the product by Id",
            description = "REST API to fetch the product by ID"
    )
    @GetMapping("/{id}")
    public ProductDTO getAllProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //update
    //the operation annotation is the part of swagger
    @Operation(
            summary = "Update the product in database",
            description = "REST API to Update the product in database"
    )

    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    //delete
    //the operation annotation is the part of swagger
    @Operation(
            summary = "Delete the Product from database",
            description = "REST API to Delete the Product from database"
    )

    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }

}
