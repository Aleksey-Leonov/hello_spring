package ru.azor.lesson2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private int id;
    private String title;
    private int cost;

    @Override
    public String toString() {
        return title + " (id=" + id + ") cost= " + cost;
    }
}
