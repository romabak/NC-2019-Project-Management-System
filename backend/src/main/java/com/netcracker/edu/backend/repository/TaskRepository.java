package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Integer>{
}