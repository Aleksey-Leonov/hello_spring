package ru.azor.lesson2;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class CartImpl implements Cart {
    private final List<Product> cart = new ArrayList<>();

    @Override
    public void addProduct(int id) {
        Product product = getProductRepository().getProductById(id);
        if (product == null) {
            return;
        }
        cart.add(product);
        System.out.println(product.getTitle() + "(id=" + id + ")" + " added to Cart");
    }

    @Override
    public void removeProduct(int id) {
        Product product = getProductRepository().getProductById(id);
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

    @Override
    @Lookup
    public ProductRepository getProductRepository() {
        return null;
    }
}
