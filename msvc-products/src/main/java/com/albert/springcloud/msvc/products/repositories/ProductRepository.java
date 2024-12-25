package com.albert.springcloud.msvc.products.repositories;

import org.springframework.data.repository.CrudRepository;

import com.albert.springcloud.msvc.products.entities.Product;

// This interface extends the CrudRepository interface, which provides basic CRUD operations.
public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
