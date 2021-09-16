package ru.geekbrains.alekseiterentev.beans.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SessionFactoryBean {

    private static final String CONFIG = "configs/hibernate/pcfg.xml";

    private SessionFactory sessionFactory;

    @PostConstruct
    private void init() {
        sessionFactory = new Configuration()
                .configure(CONFIG)
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @PreDestroy
    private void close() {
        sessionFactory.close();
    }
}
