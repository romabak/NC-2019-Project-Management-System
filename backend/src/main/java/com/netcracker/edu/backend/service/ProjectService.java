package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.ProjectEntity;

public interface ProjectService {
	Iterable<ProjectEntity> findAllProjects();
	ProjectEntity saveProject(ProjectEntity project);
	void deleteProject(Integer id);
}
