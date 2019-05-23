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
import java.util.Objects;

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

    @RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
    public ResponseEntity<TaskEntity> getTaskByName(@PathVariable(name = "id") int id){
        Optional<TaskEntity> task = taskService.findById(id);
        return ResponseEntity.ok(task.get());
    }

    @RequestMapping(value = "/{email}", params = {"size", "page"}, method = RequestMethod.GET)
    public Iterable<TaskEntity> getPage(@PathVariable(value = "email") String email,
                                        @RequestParam(value = "filter", required = false) String filter,
                                        @RequestParam(value = "page") int page,
                                        @RequestParam(value = "size") int size,
                                        @RequestParam(value = "role", required = false) String role){
        String status = "ready for test";
        Pageable pageable = PageRequest.of(page, size);
        if(Objects.equals(role, "tester")){
            if(filter == null){
                return this.taskService.findAllByStatus(status, pageable );
            } else {
                return this.taskService.findAllByStatusAndFilter(status, filter, pageable);
            }
        } else {
            if(filter == null){
                return this.taskService.findAll(email, pageable);
            } else {
                return this.taskService.findAllByFilter(email, filter, pageable);
            }
        }
    }

}