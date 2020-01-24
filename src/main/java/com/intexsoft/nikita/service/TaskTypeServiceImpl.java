package com.intexsoft.nikita.service;

import com.intexsoft.nikita.entity.TaskType;
import com.intexsoft.nikita.repository.ITaskTypeRepository;
import com.intexsoft.nikita.repository.TaskTypeRepositoryImpl;

public class TaskTypeServiceImpl implements ITaskTypeService{

    private final ITaskTypeRepository taskTypeRepository = new TaskTypeRepositoryImpl();

    @Override
    public TaskType getTaskTypeById(Long id) {
        return taskTypeRepository.getTaskTypeById(id);
    }
}
