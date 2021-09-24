package ru.geekbrains.alekseiterentev.beans.services;

import ru.geekbrains.alekseiterentev.model.Client;
import ru.geekbrains.alekseiterentev.model.Product;

import java.util.List;

public interface ShoppingReportService {

    List<Product> findProductsOrderedByClientId(Long clientId);
    List<Client> findClientsByOrderedProductId(Long productId);
}
