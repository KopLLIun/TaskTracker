package com.intexsoft.nikita.util;

import com.intexsoft.nikita.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Comment.class);
                configuration.addAnnotatedClass(Request.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Task.class);
                configuration.addAnnotatedClass(TaskJournal.class);
                configuration.addAnnotatedClass(TaskStatus.class);
                configuration.addAnnotatedClass(TaskType.class);
                configuration.addAnnotatedClass(TaskTypeCustomFields.class);
                configuration.addAnnotatedClass(TaskTypeCustomFieldsValues.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
        return sessionFactory;
    }
}
