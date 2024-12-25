package com.albert.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albert.springcloud.msvc.items.clients.ProductFeignClient;
import com.albert.springcloud.msvc.items.models.ItemDto;
import com.albert.springcloud.msvc.items.models.ProductDto;

@Service
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductFeignClient client;

    @Override
    public List<ItemDto> findAll() {
        return client.findAll().stream().map(product -> new ItemDto(product, new Random().nextInt(10) + 1))
            .collect(Collectors.toList());
    }
    

    @Override
    public Optional<ItemDto> findById(Long id) {
        ProductDto product = client.details(id);
        if (product == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(new ItemDto(client.details(id), new Random().nextInt(10) + 1));
        
    }

}
