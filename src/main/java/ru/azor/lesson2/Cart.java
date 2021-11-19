package ru.azor.lesson2;

public interface Cart {

    void addProduct(int id);

    void removeProduct(int id);

    void showCart();

    ProductRepository getProductRepository();
}
