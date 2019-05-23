package com.netcracker.edu.service;

import com.netcracker.edu.models.pageModels.PageTaskDBModel;
import com.netcracker.edu.models.TaskDBModel;

import java.util.List;

public interface TaskDataService {
    List<TaskDBModel> getAll();
    PageTaskDBModel getPage(String email, String role, String filter, int page, int size);
    TaskDBModel saveNewTask(TaskDBModel task);
    TaskDBModel getById(int id);
}
