package com.intexsoft.nikita.repository;

import com.intexsoft.nikita.entity.TaskType;
import com.intexsoft.nikita.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TaskTypeRepositoryImpl implements ITaskTypeRepository {

    private final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    @Override
    public TaskType getTaskTypeById(Long id) {

        Session session = sessionFactory.openSession();
        TaskType taskType = session.get(TaskType.class, id);
        session.close();
        return taskType;
    }
}
