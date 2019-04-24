package com.netcracker.name.service.impl;

import com.netcracker.name.models.TaskDBModel;
import com.netcracker.name.service.TaskDataService;
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
    public TaskDBModel saveNewTask(TaskDBModel task) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/task", task, TaskDBModel.class).getBody();
    }

    @Override
    public TaskDBModel getById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/task/" + id, TaskDBModel.class);
    }
}
