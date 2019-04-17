package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.ProjectEntity;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController{
	
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Iterable<ProjectEntity> getAllProjects(){
		return projectService.findAllProjects();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ProjectEntity createNewProject(@RequestBody ProjectEntity project){
		return projectService.saveProject(project);
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable(name = "id") Integer id){
		projectService.deleteProject(id);
	}
}
