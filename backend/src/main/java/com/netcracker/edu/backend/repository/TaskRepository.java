package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.TaskEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, Integer> {
    Optional<TaskEntity> findByName(String name);
    Page<TaskEntity> findAllByName(String name, Pageable pageable);
    @Query(value = "select * from task where task.ticket_code = :str or task.name = :str or task.reporter in (select id from user where first_name = :str or second_name = :str) or task.assignee in (select id from user where first_name = :str or second_name = :str)", nativeQuery = true)
    Page<TaskEntity> findAllByFilter(@Param("str") String str, Pageable pageable);
}