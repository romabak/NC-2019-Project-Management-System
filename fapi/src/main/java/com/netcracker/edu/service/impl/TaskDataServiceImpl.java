package com.netcracker.edu.service.impl;

import com.netcracker.edu.models.PageTaskDBModel;
import com.netcracker.edu.models.TaskDBModel;
import com.netcracker.edu.service.TaskDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TaskDataServiceImpl implements TaskDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<TaskDBModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        TaskDBModel[] taskDBModelResponse = restTemplate.getForObject(backendServerUrl + "/api/task", TaskDBModel[].class);
        return taskDBModelResponse == null ? Collections.emptyList() : Arrays.asList(taskDBModelResponse);
    }

    @Override
    public PageTaskDBModel getPage(int page, int size) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/task?page=" + page + "&size=" + size, PageTaskDBModel.class);
    }

    @Override
    public TaskDBModel saveNewTask(TaskDBModel task) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/task", task, TaskDBModel.class).getBody();
    }

    @Override
    public TaskDBModel getById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/task/" + id, TaskDBModel.class);
    }

    @Override
    public TaskDBModel updateTask(TaskDBModel task) {
        RestTemplate restTemplate = new RestTemplate();
        TaskDBModel taskById = getById(task.getId());
        taskById = task;
        return restTemplate.postForObject(backendServerUrl + "/api/task/", task, TaskDBModel.class);
    }
}
