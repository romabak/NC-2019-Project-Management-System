package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.TaskEntity;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class TaskServiceImpl implements TaskService {
	
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

	@Override
	public Optional<TaskEntity> findByName(String name) {
		return this.repository.findByName(name);
	}

	@Override
	public Page<TaskEntity> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	@Override
	public Page<TaskEntity> findAllByName(String name, Pageable pageable) {
		return this.repository.findAllByName(name, pageable);
	}
}
