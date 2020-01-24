package com.intexsoft.nikita.repository;

import com.intexsoft.nikita.entity.User;
import com.intexsoft.nikita.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserRepositoryImpl implements IUserRepository{

    private final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    @Override
    public void addUser(User user) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }
}
