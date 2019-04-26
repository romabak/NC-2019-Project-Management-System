package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.TaskEntity;

import java.util.Optional;

public interface TaskService extends IDefaultOperationService<TaskEntity> {
    Optional<TaskEntity> findByName(String name);
}
