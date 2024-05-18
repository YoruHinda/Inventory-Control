package com.github.yoruhinda.inventoryControl.controllers;

import com.github.yoruhinda.inventoryControl.dto.ProductDto;
import com.github.yoruhinda.inventoryControl.models.Product;
import com.github.yoruhinda.inventoryControl.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryControlController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        if (productService.findById(id).isPresent()) {
            Product product = productService.findById(id).get();
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> saveAll(@RequestBody @Valid List<ProductDto> productDtos) {
        return new ResponseEntity<>(productService.saveAll(productDtos), HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        if(productService.findById(id).isPresent()){
            return new ResponseEntity<>(productService.update(id, productDto), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        if(productService.findById(id).isPresent()){
            Product product = productService.findById(id).get();
            productService.delete(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
