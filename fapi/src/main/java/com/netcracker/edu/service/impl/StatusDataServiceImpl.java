package com.netcracker.edu.service.impl;

import com.netcracker.edu.models.StatusViewModel;
import com.netcracker.edu.service.StatusDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StatusDataServiceImpl implements StatusDataService {

    @Value("http://localhost:8080/")
    private String backendUrl;

    @Override
    public List<StatusViewModel> getAll(){
        RestTemplate restTemplate = new RestTemplate();
        StatusViewModel[] statusViewModelsResponse = restTemplate.getForObject(backendUrl + "/api/status",
                StatusViewModel[].class);
        return statusViewModelsResponse == null ? Collections.emptyList() : Arrays.asList(statusViewModelsResponse);
    }

    @Override
    public StatusViewModel getByStatus(String name) {
        return new RestTemplate().getForObject(backendUrl + "/api/status/" + name, StatusViewModel.class);
    }

}
