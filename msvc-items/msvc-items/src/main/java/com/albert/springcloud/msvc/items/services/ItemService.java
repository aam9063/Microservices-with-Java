package com.albert.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;

import com.albert.springcloud.msvc.items.models.ItemDto;

public interface ItemService {

    List<ItemDto> findAll();
    Optional<ItemDto> findById(Long id);

}
