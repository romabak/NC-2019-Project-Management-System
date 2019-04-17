package com.netcracker.name.service.impl;

import com.netcracker.name.models.ProjectViewModel;
import com.netcracker.name.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectDataServiceImpl implements ProjectDataService {

    @Value("${backend.server.url}")
    private String backendUrl;

    @Override
    public ProjectViewModel saveNewProject(ProjectViewModel project) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendUrl + "api/project", project, ProjectViewModel.class).getBody();
    }
}
