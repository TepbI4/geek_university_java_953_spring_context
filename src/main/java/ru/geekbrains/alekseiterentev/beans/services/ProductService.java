package ru.geekbrains.alekseiterentev.beans.services;

import ru.geekbrains.alekseiterentev.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
}
