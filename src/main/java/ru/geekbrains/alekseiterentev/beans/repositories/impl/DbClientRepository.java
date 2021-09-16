package ru.geekbrains.alekseiterentev.beans.repositories.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.alekseiterentev.beans.db.SessionFactoryBean;
import ru.geekbrains.alekseiterentev.beans.repositories.ClientRepository;
import ru.geekbrains.alekseiterentev.model.Client;
import ru.geekbrains.alekseiterentev.model.Product;

import java.util.List;

@Component
public class DbClientRepository implements ClientRepository {

    SessionFactoryBean sessionFactoryBean;

    @Autowired
    public void setSessionFactoryBean(SessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    @Override
    public List<Client> findAllClients() {
        try(Session session = sessionFactoryBean.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Client> clients = session.createQuery("from Client").getResultList();
            session.getTransaction().commit();
            return clients;
        }
    }

    @Override
    public Client findById(Long id) {
        try(Session session = sessionFactoryBean.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.getTransaction().commit();
            return client;
        }
    }
}
