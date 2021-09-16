package ru.geekbrains.alekseiterentev.beans.services;

import ru.geekbrains.alekseiterentev.model.Client;
import ru.geekbrains.alekseiterentev.model.Product;

import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findById(Long id);
}
