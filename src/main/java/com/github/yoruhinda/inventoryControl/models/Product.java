package com.github.yoruhinda.inventoryControl.models;

import com.github.yoruhinda.inventoryControl.enums.ProductStatus;

public class Product {
    private Long productID;
    private String name;
    private Long quantity;
    private float price;
    private ProductStatus productStatus;
}
