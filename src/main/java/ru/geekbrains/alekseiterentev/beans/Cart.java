package ru.geekbrains.alekseiterentev.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.alekseiterentev.beans.repositories.ProductRepository;
import ru.geekbrains.alekseiterentev.beans.services.ProductService;
import ru.geekbrains.alekseiterentev.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class Cart {

    private ProductService productService;

    private List<Product> items = new ArrayList<>();

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void addProduct(Long id) {
        Product product = productService.findById(id);
        if (Objects.nonNull(product)) {
            items.add(product);
        }
    }

    public void removeProduct(Long id) {
        items.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items.stream().map(Objects::toString).collect(Collectors.joining(",")) +
                '}';
    }
}
