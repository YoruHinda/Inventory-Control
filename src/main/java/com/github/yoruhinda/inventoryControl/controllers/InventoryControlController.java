package com.github.yoruhinda.inventoryControl.controllers;

import com.github.yoruhinda.inventoryControl.dto.ProductDto;
import com.github.yoruhinda.inventoryControl.models.Product;
import com.github.yoruhinda.inventoryControl.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class InventoryControlController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id){
        Product product = productService.findById(id).orElseThrow(NoSuchElementException::new);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> saveAll(@RequestBody List<ProductDto> productDtos){
        return new ResponseEntity<>(productService.saveAll(productDtos), HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.update(id, productDto), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
