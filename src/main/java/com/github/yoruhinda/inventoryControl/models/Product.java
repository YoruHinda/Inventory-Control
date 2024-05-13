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
    private Long quantity;
    @Column(name = "price")
    private float price;
    @Enumerated(EnumType.STRING)
    @Column(name = "ProductStatus")
    private ProductStatus product_status;
}
