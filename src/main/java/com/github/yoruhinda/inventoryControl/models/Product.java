package com.github.yoruhinda.inventoryControl.models;

import com.github.yoruhinda.inventoryControl.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue
    private Long productID;
    @Column
    private String name;
    @Column
    private Long quantity;
    @Column
    private float price;
    @Enumerated(EnumType.STRING)
    @Column(name = "ProductStatus")
    private ProductStatus productStatus;
}
