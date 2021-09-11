package ru.geekbrains.alekseiterentev.beans.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.alekseiterentev.beans.repositories.ProductRepository;
import ru.geekbrains.alekseiterentev.beans.services.ProductService;
import ru.geekbrains.alekseiterentev.model.Product;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAllProducts();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
