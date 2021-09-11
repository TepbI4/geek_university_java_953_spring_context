package ru.geekbrains.alekseiterentev.beans.repositories;

import ru.geekbrains.alekseiterentev.model.Product;

import java.util.List;

public interface ProductRepository {

    void init();
    List<Product> findAllProducts();
    Product findById(Long id);
}
