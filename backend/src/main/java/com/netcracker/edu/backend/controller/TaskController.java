package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.TaskEntity;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController{

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<TaskEntity> getAllTasks(){
        return this.taskService.getAllTasks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable(name = "id") Integer id){
        this.taskService.deleteTask(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public TaskEntity saveTasks(@RequestBody TaskEntity task){
        return this.taskService.addTask(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable(name = "id") Integer id){
        Optional<TaskEntity> task = taskService.getTaskById(id);
        if(task.isPresent()){
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}