package ru.azor.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HandleCart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CartConfiguration.class);
        context.getBean(ProductRepository.class).showProducts();
        Cart currentCart = context.getBean(Cart.class);
        currentCart.addProduct(1);
        currentCart.addProduct(2);
        currentCart.addProduct(3);
        currentCart.showCart();
        currentCart.removeProduct(1);
        currentCart.showCart();
    }
}
