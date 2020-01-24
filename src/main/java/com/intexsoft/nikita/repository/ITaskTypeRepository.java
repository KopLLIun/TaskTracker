package com.intexsoft.nikita.repository;

import com.intexsoft.nikita.entity.TaskType;

public interface ITaskTypeRepository {

    TaskType getTaskTypeById(Long id);
}
