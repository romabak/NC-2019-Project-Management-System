package com.netcracker.name.service.impl;

import com.netcracker.name.models.ProjectViewModel;
import com.netcracker.name.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectDataServiceImpl implements ProjectDataService {

    @Value("${backend.server.url}")
    private String backendUrl;

    @Override
    public ProjectViewModel saveNewProject(ProjectViewModel project) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendUrl + "api/project", project, ProjectViewModel.class).getBody();
    }
    
    @Override
    public List<ProjectViewModel> getAllProject(){
	    RestTemplate restTemplate = new RestTemplate();
	    ProjectViewModel[] projectViewModelResponse = restTemplate.getForObject(backendUrl + "/api/project", ProjectViewModel[].class);
	    return projectViewModelResponse == null ? Collections.emptyList() : Arrays.asList(projectViewModelResponse);
    }

    @Override
    public ProjectViewModel getProjectById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendUrl + "/api/project/" + id, ProjectViewModel.class);

    }

    @Override
    public ProjectViewModel getProjectByCode(String code) {
        return new RestTemplate().getForObject(backendUrl + "/api/project/" + code, ProjectViewModel.class);
    }
}
