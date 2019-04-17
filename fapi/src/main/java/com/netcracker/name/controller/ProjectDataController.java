package com.netcracker.name.controller;


import com.netcracker.name.models.ProjectViewModel;
import com.netcracker.name.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/project")
public class ProjectDataController {

    private ProjectDataService projectDataService;

    @Autowired
    public ProjectDataController(ProjectDataService projectDataService){
        this.projectDataService = projectDataService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ProjectViewModel saveNewProject(@RequestBody ProjectViewModel projectViewModel){
        return projectDataService.saveNewProject(projectViewModel);
    }

}
