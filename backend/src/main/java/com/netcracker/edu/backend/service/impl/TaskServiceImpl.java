package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.TaskEntity;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.*;
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
	public Iterable<TaskEntity> getAllTasks(){
		return this.repository.findAll();
	}

	@Override
	public TaskEntity addTask(TaskEntity task){
		return this.repository.save(task);
	}
	
	@Override
	public void deleteTask(Integer id){
		this.repository.deleteById(id);
	}

	@Override
	public Optional<TaskEntity> getTaskById(Integer id){
		return this.repository.findById(id);
	}
}
