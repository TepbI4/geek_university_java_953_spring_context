package ru.geekbrains.alekseiterentev.beans.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.alekseiterentev.beans.services.ClientService;
import ru.geekbrains.alekseiterentev.beans.services.ProductService;
import ru.geekbrains.alekseiterentev.beans.services.ShoppingReportService;
import ru.geekbrains.alekseiterentev.model.Client;
import ru.geekbrains.alekseiterentev.model.Product;

import java.util.List;

@Service
public class ShoppingReportServiceImpl implements ShoppingReportService {

    ProductService productService;
    ClientService clientService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public List<Product> findProductsOrderedByClientId(Long clientId) {
        return clientService.findById(clientId).getProducts();
    }

    @Override
    public List<Client> findClientsByOrderedProductId(Long productId) {
        return productService.findById(productId).getClients();
    }
}
