package com.netcracker.edu.service;

import com.netcracker.edu.models.PageTaskDBModel;
import com.netcracker.edu.models.TaskDBModel;

import java.util.List;

public interface TaskDataService {
    List<TaskDBModel> getAll();
    PageTaskDBModel getPage(int page, int size);
    TaskDBModel saveNewTask(TaskDBModel task);
    TaskDBModel getById(int id);
    TaskDBModel updateTask(TaskDBModel task);
}
