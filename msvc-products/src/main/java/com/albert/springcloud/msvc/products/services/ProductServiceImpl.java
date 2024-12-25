package com.albert.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albert.springcloud.msvc.products.entities.Product;
import com.albert.springcloud.msvc.products.repositories.ProductRepository;

@Service // This annotation marks this class as a Spring service.
public class ProductServiceImpl implements ProductService { // This class implements the ProductService interface.

    final private ProductRepository repository; // this is for protecting the repository from being changed by other classes.

    // This constructor initializes the repository field.
    // @Autowired // This annotation is not needed in the constructor because Spring Boot automatically injects the repository into the constructor.
    public ProductServiceImpl(ProductRepository repository) {
       this.repository = repository; 
    }


    @Override // This annotation indicates that the following method is an implementation of a method declared in the ProductService interface.
    @Transactional(readOnly = true) // This means that the method will be executed within a transaction.
    public List<Product> findAll() { // This method returns a list of all products.
        return (List<Product>) repository.findAll(); // This line returns all products from the repository.
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) { // This method returns a product with the specified ID.
        return repository.findById(id);
    }

}
