package com.github.yoruhinda.inventoryControl.dto;

import com.github.yoruhinda.inventoryControl.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto {
    private String name;
    private Long quantity;
    private float price;
    private ProductStatus productStatus;
}
