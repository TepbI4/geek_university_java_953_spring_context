package ru.geekbrains.alekseiterentev.beans.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.alekseiterentev.beans.repositories.ClientRepository;
import ru.geekbrains.alekseiterentev.beans.services.ClientService;
import ru.geekbrains.alekseiterentev.model.Client;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAllClients();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id);
    }
}
