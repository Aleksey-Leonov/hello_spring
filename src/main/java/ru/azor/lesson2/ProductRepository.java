package ru.azor.lesson2;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();

    Product getProductById(int id);

    void showProducts();
}
