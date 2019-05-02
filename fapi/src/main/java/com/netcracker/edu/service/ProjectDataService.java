package com.netcracker.edu.service;

import com.netcracker.edu.models.ProjectViewModel;

import java.util.List;

public interface ProjectDataService {
    ProjectViewModel saveNewProject(ProjectViewModel project);
    List<ProjectViewModel> getAllProject();
    ProjectViewModel getProjectById(Integer id);
    ProjectViewModel getProjectByCode(String code);
}
