package com.github.yoruhinda.inventoryControl.dto;

import com.github.yoruhinda.inventoryControl.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private int quantity;
    private float price;

    public Product convertDtoToEntity(){
        return new Product(this.getName(), this.getQuantity(), this.getPrice());
    }
}
