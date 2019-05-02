package com.netcracker.edu.controller;


import com.netcracker.edu.models.DTOModels.PageTaskDTOModel;
import com.netcracker.edu.models.DTOModels.TaskDTOModel;
import com.netcracker.edu.models.PageTaskDBModel;
import com.netcracker.edu.models.TaskDBModel;
import com.netcracker.edu.service.*;
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

    @RequestMapping(value = "", params = {"page", "size"}, method = RequestMethod.GET)
    public ResponseEntity<PageTaskDTOModel> getPage(@RequestParam(value = "page") int page, @RequestParam(value = "size", defaultValue = "5") int size){
         PageTaskDBModel tasks = taskDataService.getPage(page, size);
         List<TaskDTOModel> tasksDto =  tasks.getContent().stream().map(task-> new TaskDTOModel(task)).collect(Collectors.toList());
         PageTaskDTOModel pageDto = new PageTaskDTOModel(tasksDto, tasks.getTotalPages(), tasks.getNumberOfElements(), tasks.getSize(), tasks.getTotalElements());
         return ResponseEntity.ok(pageDto);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public TaskDBModel saveNewTask(@RequestBody TaskDTOModel task){
        return taskDataService.saveNewTask(convertToEntity(task));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public TaskDBModel updateTask(@RequestBody TaskDTOModel task){
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
