package com.zhanarbek.configs;

import com.zhanarbek.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.stereotype.Component;

/**
 * Author: Zhanarbek Abdurasulov
 * Date: 22/2/22
 */
@Component
public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().setProperty(Environment.DRIVER, "org.postgresql.Driver")
                    .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect")
                    .setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/test")
                    .setProperty(Environment.USER, "postgres")
                    .setProperty(Environment.PASS, "1992")
                    .setProperty(Environment.HBM2DDL_AUTO, "update")
                    .setProperty(Environment.SHOW_SQL, "true")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
    public static void shutDown() {
        getSessionFactory().close();
    }
}
