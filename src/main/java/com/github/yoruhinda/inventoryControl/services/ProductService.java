package com.github.yoruhinda.inventoryControl.services;

import com.github.yoruhinda.inventoryControl.dto.ProductDto;
import com.github.yoruhinda.inventoryControl.models.Product;
import com.github.yoruhinda.inventoryControl.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(ProductDto productDto){
        Product product = productDto.convertDtoToEntity();
        return productRepository.save(product);
    }

    public List<Product> saveAll(List<ProductDto> productDtos){
        List<Product> products = new ArrayList<>();
        for(ProductDto productDto : productDtos){
            products.add(productDto.convertDtoToEntity());
        }
        return productRepository.saveAll(products);
    }

    public Product update(Long id, ProductDto productDto){
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.verifyProductInStock(productDto.getQuantity());
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
