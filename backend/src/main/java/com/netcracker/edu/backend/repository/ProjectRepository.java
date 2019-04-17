package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Integer> {
}
