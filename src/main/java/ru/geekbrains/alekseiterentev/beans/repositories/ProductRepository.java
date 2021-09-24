package ru.geekbrains.alekseiterentev.beans.repositories;

import ru.geekbrains.alekseiterentev.model.Client;
import ru.geekbrains.alekseiterentev.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAllProducts();
    Product findById(Long id);
}
