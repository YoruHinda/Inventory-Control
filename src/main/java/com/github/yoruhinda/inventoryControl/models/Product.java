package com.github.yoruhinda.inventoryControl.models;

import com.github.yoruhinda.inventoryControl.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private float price;
    @Enumerated(EnumType.STRING)
    @Column(name = "ProductStatus")
    private ProductStatus product_status;

    public Product(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        verifyProductInStock(quantity);
    }

    private void verifyProductInStock(int quantity) {
        if(quantity > 0){
            this.product_status = ProductStatus.IN_STOCK;
        }else {
            this.product_status = ProductStatus.OUT_OF_STOCK;
        }
    }
}
