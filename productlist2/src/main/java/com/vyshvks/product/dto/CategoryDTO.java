package com.vyshvks.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

//@Getter
//@Setter

//schema annotation belong to swagger one
@Schema(
        name = "Category",
        description = "It hold the Category Information along with there Products"
)
@Data //this annotation is both getter and setter together
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDTO> products;
}
