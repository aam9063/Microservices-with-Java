package com.albert.springcloud.msvc.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.albert.springcloud.msvc.items.models.ProductDto;

// This annotation indicates that this interface will be a Feign client and that it will make requests to the specified URL
@FeignClient(url = "localhost:8001") 
public interface ProductFeignClient {
    // This method will be called when the client makes a GET request to the / endpoint
    @GetMapping
    List<ProductDto> findAll(); 

       // @GetMapping("/products/{id}")
    @GetMapping("/{id}")
    ProductDto details(@PathVariable Long id);
}
