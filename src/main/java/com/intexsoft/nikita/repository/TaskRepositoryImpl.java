package com.intexsoft.nikita.repository;

import com.intexsoft.nikita.entity.Task;
import com.intexsoft.nikita.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TaskRepositoryImpl implements ITaskRepository {

    private static final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    @Override
    public Task getTaskById(Long id) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
/*        Session session = sessionFactory.openSession();
        Task task = (Task) session.get(Task.class, id);
        System.out.println(task);
        session.close();*/
        return sessionFactory.openSession().get(Task.class, id);
    }

    @Override
    public List<Task> getTasks() {
//        sessionFactory.openSession().createQuery("From Task").list().forEach(System.out::println);
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.createQuery("From Task").list();
        session.close();
        return tasks;
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
    public void deleteTask(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Task task = (Task) session.load(Task.class, id);
        session.delete(task);
        System.out.println("Task deleted");
        transaction.commit();
        session.close();
    }
}
