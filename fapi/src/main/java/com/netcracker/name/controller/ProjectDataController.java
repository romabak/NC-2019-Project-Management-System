package com.netcracker.name.controller;


import com.netcracker.name.models.ProjectViewModel;
import com.netcracker.name.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/project")
public class ProjectDataController {

    private ProjectDataService projectDataService;

    @Autowired
    public ProjectDataController(ProjectDataService projectDataService){
        this.projectDataService = projectDataService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectViewModel>> getAllProjects(){
	   return ResponseEntity.ok(projectDataService.getAllProject());
    }


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ProjectViewModel saveNewProject(@RequestBody ProjectViewModel projectViewModel){
        return projectDataService.saveNewProject(projectViewModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProjectViewModel> getProjectById(@PathVariable (name = "id") Integer id){
        return ResponseEntity.ok(projectDataService.getProjectById(id));
    }

}
