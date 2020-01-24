package com.intexsoft.nikita.repository;

import com.intexsoft.nikita.entity.Task;

import java.util.List;

public interface ITaskRepository {
    Task getTaskById(Long id);
    List<Task> getTasks();
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(Long id);
}

