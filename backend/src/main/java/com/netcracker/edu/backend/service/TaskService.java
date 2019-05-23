package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskService extends IDefaultOperationService<TaskEntity> {
    Optional<TaskEntity> findByName(String name);
    Page<TaskEntity> findAll(String email, Pageable pageable);
    Page<TaskEntity> findAllByFilter(String email, String filter, Pageable pageable);
    Page<TaskEntity> findAllByStatus(String status, Pageable page);
    Page<TaskEntity> findAllByStatusAndFilter(String status, String filter, Pageable page);
}
