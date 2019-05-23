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

    @Query(value = "select * from task where (select id from user where email = :email) in (task.reporter, task.assignee)" +
            "and" +
            ":str in (task.name, task.ticket_code)",
            nativeQuery = true)
    Page<TaskEntity> findAllByFilter(@Param("email") String email, @Param("str") String str, Pageable pageable);

    @Query(value = "select * from task where task.status_id = (select id from status where status = :status)",
        nativeQuery = true)
    Page<TaskEntity> findAllByStatus(@Param("status") String status, Pageable page);

    @Query(value = "select * from task where status_id = (select id from status where status = :status) " +
            "and" +
            ":filter in (task.ticket_code, task.name)", nativeQuery = true)
    Page<TaskEntity> findAllByStatusAndFilter(@Param("status") String status, @Param("filter") String filter, Pageable page);

    @Query(value = "select * from task where assignee = (select id from user where email = :email)" +
            "or reporter = ((select id from user where email = :email))",
    nativeQuery = true)
    Page<TaskEntity> findAll(String email, Pageable pageable);
}