package com.example.hiborm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = build();

    private static SessionFactory build() {
        try {
            // Loads hibernate.cfg.xml from classpath
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception ex) {
            throw new RuntimeException("Initial SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        sessionFactory.close();
    }
}
