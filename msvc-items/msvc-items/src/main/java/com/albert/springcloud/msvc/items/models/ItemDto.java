package com.albert.springcloud.msvc.items.models;

public class ItemDto {

    private ProductDto product;
    private int quantity;

    public ItemDto(ProductDto product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return product;
    }
    public void setProduct(ProductDto product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return product.getPrice() * quantity;
    }

    
}
