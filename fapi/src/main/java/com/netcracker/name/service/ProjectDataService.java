package com.netcracker.name.service;

import com.netcracker.name.models.ProjectViewModel;

import java.util.List;

public interface ProjectDataService {
    ProjectViewModel saveNewProject(ProjectViewModel project);
    List<ProjectViewModel> getAllProject();
    ProjectViewModel getProjectById(Integer id);
    ProjectViewModel getProjectByCode(String code);
}
