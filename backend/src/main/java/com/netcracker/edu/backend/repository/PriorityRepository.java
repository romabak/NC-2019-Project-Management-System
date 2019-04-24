package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.PriorityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends CrudRepository<PriorityEntity, Integer> {
    PriorityEntity findByPriority(String priority);
}
