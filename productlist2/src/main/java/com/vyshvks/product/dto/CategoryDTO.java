package com.vyshvks.product.dto;

import lombok.*;

import java.util.List;

//@Getter
//@Setter

@Data //act has all above import one's
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDTO> products;
}
