package com.github.yoruhinda.inventoryControl.dto;

import com.github.yoruhinda.inventoryControl.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    @NotEmpty
    private String name;
    private int quantity;
    private float price;

    public Product convertDtoToEntity(){
        return new Product(this.getName(), this.getQuantity(), this.getPrice());
    }
}
