package ru.geekbrains.alekseiterentev.beans.repositories.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.alekseiterentev.beans.db.SessionFactoryBean;
import ru.geekbrains.alekseiterentev.beans.repositories.ProductRepository;
import ru.geekbrains.alekseiterentev.model.Client;
import ru.geekbrains.alekseiterentev.model.Product;

import java.util.List;

@Component
public class DbProductRepository implements ProductRepository {

    SessionFactoryBean sessionFactoryBean;

    @Autowired
    public void setSessionFactoryBean(SessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    @Override
    public List<Product> findAllProducts() {
        try(Session session = sessionFactoryBean.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findById(Long id) {
        try(Session session = sessionFactoryBean.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }
}
