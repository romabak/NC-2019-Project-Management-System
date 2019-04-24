package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.ProjectEntity;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController{
	
	private IDefaultOperationService<ProjectEntity> projectService;
	private FindService<ProjectEntity> findService;

	@Autowired
	public ProjectController(IDefaultOperationService<ProjectEntity> projectService, FindService<ProjectEntity> findService) {
		this.projectService = projectService;
		this.findService = findService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Iterable<ProjectEntity> getAllProjects(){
		return projectService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ProjectEntity createNewProject(@RequestBody ProjectEntity project){
		return projectService.save(project);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable(name = "id") Integer id){
		projectService.delete(id);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ResponseEntity getProjectByCode(@PathVariable (name = "code") String code){
		ProjectEntity project = findService.findByName(code);
			return ResponseEntity.ok(project);
	}
}
