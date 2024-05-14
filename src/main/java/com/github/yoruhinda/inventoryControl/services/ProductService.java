package com.github.yoruhinda.inventoryControl.services;

import com.github.yoruhinda.inventoryControl.dto.ProductDto;
import com.github.yoruhinda.inventoryControl.enums.ProductStatus;
import com.github.yoruhinda.inventoryControl.models.Product;
import com.github.yoruhinda.inventoryControl.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).get();
    }

    public Product save(ProductDto productDto){
        Product product = new Product(productDto.getName(), productDto.getQuantity(), productDto.getPrice());
        if(productDto.getQuantity() > 0){
            product.setProduct_status(ProductStatus.IN_STOCK);
        }else {
            product.setProduct_status(ProductStatus.OUT_OF_STOCK);
        }
        return productRepository.save(product);
    }

    public Product update(Long id, ProductDto productDto){
        return null;
    }

    public Product delete(Long id){
        return null;
    }
}
