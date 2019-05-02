package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, Integer> {
    Optional<TaskEntity> findByName(String name);
    Page<TaskEntity> findAllByName(String name, Pageable pageable);
}