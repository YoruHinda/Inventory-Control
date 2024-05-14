package com.github.yoruhinda.inventoryControl.dto;

import com.github.yoruhinda.inventoryControl.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private int quantity;
    private float price;
    private ProductStatus productStatus;
}
