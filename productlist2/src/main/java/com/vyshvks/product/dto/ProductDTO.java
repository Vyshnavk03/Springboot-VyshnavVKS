package com.vyshvks.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//schema annotation belong to swagger one
@Schema(
        name = "Product",
        description = "It hold the Product Information along with there Respective Category"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long CategoryId;

}
