package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaskService extends IDefaultOperationService<TaskEntity> {
    Optional<TaskEntity> findByName(String name);
    Page<TaskEntity> findAll(Pageable pageable);
    Page<TaskEntity> findAllByName(String name, Pageable pageable);
}
