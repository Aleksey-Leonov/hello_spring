package ru.azor.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    private final Random random = new Random();
    private final List<Product> products;
    private final Environment environment;

    @Autowired
    public ProductRepositoryImpl(Environment environment) {
        products = new ArrayList<>();
        this.environment = environment;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void showProducts() {
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("-------------------------------------");
    }

    @PostConstruct
    public void init() {
        String[] names = Objects.requireNonNull(environment.getProperty("listOfProductNames")).split(",");
        for (int i = 0; i < 5; i++) {
            products.add(new Product(i + 1, names[random.nextInt(names.length - 1)], random.nextInt(100)));
        }
    }
}
