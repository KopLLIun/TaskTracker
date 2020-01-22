package com.intexsoft.nikita.service;

import com.intexsoft.nikita.entity.Task;

import java.util.List;

public interface ITaskService {

    List<Task> getTasks();
    Task getTaskById(Long id);
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(Task task);
}
