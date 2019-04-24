package com.netcracker.name.service;

import com.netcracker.name.models.TaskDBModel;

import java.util.List;

public interface TaskDataService {
    List<TaskDBModel> getAll();
    TaskDBModel saveNewTask(TaskDBModel task);
    TaskDBModel getById(int id);
}
