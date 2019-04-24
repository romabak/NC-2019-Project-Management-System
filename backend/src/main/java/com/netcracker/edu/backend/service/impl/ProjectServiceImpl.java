package com.netcracker.edu.backend.service.impl;
                              
import com.netcracker.edu.backend.entity.ProjectEntity;
import com.netcracker.edu.backend.repository.ProjectRepository;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectServiceImpl implements IDefaultOperationService<ProjectEntity>, FindService<ProjectEntity> {

	@Autowired
	private ProjectRepository repository;

	@Override
	public Iterable<ProjectEntity> findAll(){
		return this.repository.findAll();
	}

	@Override
	public ProjectEntity save(ProjectEntity project){
		return this.repository.save(project);
	}

	@Override 
	public void delete(Integer id){
		this.repository.deleteById(id);
	}

	@Override
	public Optional<ProjectEntity> findById(Integer id){
		return this.repository.findById(id);
	}

	@Override
	public ProjectEntity findByName(String name) {
		return this.repository.findByCode(name);
	}
}
