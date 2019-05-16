package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.TaskEntity;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return this.taskService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable(name = "id") Integer id){
        this.taskService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public TaskEntity saveTasks(@RequestBody TaskEntity task){
        System.out.println(task.toString());
        return this.taskService.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskEntity> getTaskByName(@PathVariable(name = "id") int id){
        Optional<TaskEntity> task = taskService.findById(id);
        return ResponseEntity.ok(task.get());
    }

    @RequestMapping(value = "", params = {"size", "page"}, method = RequestMethod.GET)
    public Iterable<TaskEntity> getPage(@RequestParam(value = "page") int page,
                                        @RequestParam(value = "size", defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<TaskEntity> result = taskService.findAll(pageable);
        return result;
    }

    @RequestMapping(value = "/filter", params = {"filter", "size", "page"}, method = RequestMethod.GET)
    public Iterable<TaskEntity> getByFilter(@RequestParam(value = "filter") String filter,
                                            @RequestParam(value = "page") int page,
                                            @RequestParam(value = "size") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<TaskEntity> result = this.taskService.findAllByFilter(filter, pageable);
        return result;
    }

}