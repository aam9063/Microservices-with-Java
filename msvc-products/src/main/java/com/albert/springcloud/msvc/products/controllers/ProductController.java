package com.albert.springcloud.msvc.products.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.albert.springcloud.msvc.products.entities.Product;
import com.albert.springcloud.msvc.products.services.ProductService;




@RestController
public class ProductController {

    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // @GetMapping("/products")
    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(this.service.findAll());
    }

    // @GetMapping("/products/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id) {
        Optional<Product> productOptional = this.service.findById(id);
        
        // If the product exists, return it in the response.
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        } 

        return ResponseEntity.notFound().build();
    }
}
