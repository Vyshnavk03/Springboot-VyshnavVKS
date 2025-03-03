package com.vyshvks.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//mappedby is to connect with product the catagory is written inside is the category written in product and cascade is made if catagory is deleted then enitire product will be deleted inside that catagory
    private List<Product> products = new ArrayList<>();
}
