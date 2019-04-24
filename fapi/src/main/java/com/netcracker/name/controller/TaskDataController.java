package com.netcracker.name.controller;


import com.netcracker.name.models.DTOModels.TaskDTOModel;
import com.netcracker.name.models.TaskDBModel;
import com.netcracker.name.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskDataController {

    private TaskDataService taskDataService;
    private StatusDataService statusDataService;
    private PriorityDataService priorityDataService;
    private UserDataService userDataService;
    private ProjectDataService projectDataService;

    @Autowired
    public TaskDataController(ProjectDataService projectDataService, TaskDataService taskDataService, StatusDataService statusDataService, PriorityDataService priorityDataService, UserDataService userDataService) {
        this.taskDataService = taskDataService;
        this.statusDataService = statusDataService;
        this.priorityDataService = priorityDataService;
        this.userDataService = userDataService;
        this.projectDataService = projectDataService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<TaskDTOModel>> getAllTask(){
        List<TaskDBModel> tasks = taskDataService.getAll();
        List<TaskDTOModel> tasksDto = tasks.stream().map(task-> new TaskDTOModel(task)).collect(Collectors.toList());
        return ResponseEntity.ok(tasksDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskDTOModel> getById(@PathVariable (name = "id") int id){
        return Optional.ofNullable(taskDataService.getById(id))
                .map(task-> new ResponseEntity<>(new TaskDTOModel(task), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public TaskDBModel saveNewTask(@RequestBody TaskDTOModel task){
        return taskDataService.saveNewTask(convertToEntity(task));
    }

    private TaskDBModel convertToEntity(TaskDTOModel taskDto){
        TaskDBModel taskDBModel = new TaskDBModel();
        taskDBModel.setDueDate(taskDto.getDueDate());
        taskDBModel.setDescription(taskDto.getDescription());
        taskDBModel.setName(taskDto.getName());
        taskDBModel.setPriority(priorityDataService.getByPriority(taskDto.getPriority()));
        taskDBModel.setAssignee(userDataService.getByEmail(taskDto.getAssignee()));
        taskDBModel.setProject(projectDataService.getProjectByCode(taskDto.getProject()));
        taskDBModel.setEstimation(taskDto.getEstimation());
        return taskDBModel;
    }
}
