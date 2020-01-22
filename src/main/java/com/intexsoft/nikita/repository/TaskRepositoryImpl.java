package com.intexsoft.nikita.repository;

import com.intexsoft.nikita.entity.Task;
import com.intexsoft.nikita.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    private static final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    @Override
    public Task getTaskById(Long id) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        System.out.println(sessionFactory.openSession().get(Task.class, id));
        return sessionFactory.openSession().get(Task.class, id);
    }

    @Override
    public List<Task> getTasks() {
        sessionFactory.openSession().createQuery("From Task").list().forEach(System.out::println);
        return (List<Task>)sessionFactory.openSession().createQuery("From Task").list();
    }

    @Override
    public void addTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(task);
        System.out.println("New task: " + task);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(task);
        System.out.println("Task updated: " + task);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(task);
        System.out.println("Task deleted");
        transaction.commit();
        session.close();
    }
}
