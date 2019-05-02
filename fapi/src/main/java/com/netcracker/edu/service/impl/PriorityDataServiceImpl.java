package com.netcracker.edu.service.impl;

import com.netcracker.edu.models.PriorityViewModel;
import com.netcracker.edu.service.PriorityDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PriorityDataServiceImpl implements PriorityDataService {

    @Value("http://localhost:8080/")
    private String backendUrl;

    @Override
    public List<PriorityViewModel> getAll(){
        RestTemplate restTemplate = new RestTemplate();
        PriorityViewModel[] priorityViewModelResponse = restTemplate.getForObject(backendUrl + "/api/priority", PriorityViewModel[].class);
        return priorityViewModelResponse == null ? Collections.emptyList() : Arrays.asList(priorityViewModelResponse);
    }

    @Override
    public PriorityViewModel getByPriority(String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendUrl + "/api/priority/" + name, PriorityViewModel.class);
    }
}
