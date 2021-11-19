package ru.azor.lesson2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Scope("prototype")
public class CartImpl implements Cart {
    private final List<Product> cart = new ArrayList<>();
    private final ProductRepositoryImpl products;

    @Autowired
    public CartImpl(ProductRepositoryImpl products) {
        this.products = products;
    }

    @Override
    public void addProduct(int id) {
        Product product = products.getProductById(id);
        if (product == null) {
            return;
        }
        cart.add(product);
        System.out.println(product.getTitle() + "(id=" + id + ")" + " added to Cart");
    }

    @Override
    public void removeProduct(int id) {
        Product product = products.getProductById(id);
        if (cart.isEmpty()) {
            return;
        }
        cart.removeIf(currProduct -> currProduct.equals(product));
        System.out.println(product.getTitle() + "(id=" + id + ")" + " removed from Cart");
    }

    @Override
    public void showCart() {
        System.out.println("-------------------------------------");
        System.out.println("Cart contents:");
        for (Product product : cart) {
            System.out.println(product);
        }
        System.out.println("-------------------------------------");
    }
}
