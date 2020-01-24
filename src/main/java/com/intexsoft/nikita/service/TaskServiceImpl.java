package com.intexsoft.nikita.service;

import com.intexsoft.nikita.entity.Task;
import com.intexsoft.nikita.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskServiceImpl implements ITaskService {

    private final TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();

    @Override
    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }
}
