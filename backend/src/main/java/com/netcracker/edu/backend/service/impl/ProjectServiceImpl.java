package com.netcracker.edu.backend.service.impl;
                              
import com.netcracker.edu.backend.entity.ProjectEntity;
import com.netcracker.edu.backend.repository.ProjectRepository;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository repository;

	@Override
	public Iterable<ProjectEntity> findAllProjects(){
		return this.repository.findAll();
	}

	@Override
	public ProjectEntity saveProject(ProjectEntity project){
		return this.repository.save(project);
	}

	@Override 
	public void deleteProject(Integer id){
		this.repository.deleteById(id);
	}
}
