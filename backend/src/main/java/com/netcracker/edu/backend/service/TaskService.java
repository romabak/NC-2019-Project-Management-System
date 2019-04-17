package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.TaskEntity;

import java.util.Optional;

public interface TaskService {
	Iterable<TaskEntity> getAllTasks();
	void deleteTask(Integer id);
	TaskEntity addTask(TaskEntity task);
	Optional<TaskEntity> getTaskById(Integer id);
}