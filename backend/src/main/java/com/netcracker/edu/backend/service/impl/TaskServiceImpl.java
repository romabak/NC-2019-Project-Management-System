package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.TaskEntity;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class TaskServiceImpl implements IDefaultOperationService<TaskEntity> {
	
	private TaskRepository repository;

	@Autowired
	public TaskServiceImpl(TaskRepository repository){
		this.repository = repository;
	}
	
	@Override
	public Iterable<TaskEntity> findAll(){
		return this.repository.findAll();
	}

	@Override
	public TaskEntity save(TaskEntity task){
		return this.repository.save(task);
	}
	
	@Override
	public void delete(Integer id){
		this.repository.deleteById(id);
	}

	@Override
	public Optional<TaskEntity> findById(Integer id){
		return this.repository.findById(id);
	}
}
