package com.intexsoft.nikita.repository;

import com.intexsoft.nikita.entity.Request;
import com.intexsoft.nikita.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RequestRepositoryImpl implements IRequestRepository {

    @Override
    public Request getRequestById(Long id) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Request request = session.get(Request.class, id);
        session.close();
        return request;
    }
}
