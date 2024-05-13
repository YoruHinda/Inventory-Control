package com.github.yoruhinda.inventoryControl.repositories;

import com.github.yoruhinda.inventoryControl.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
