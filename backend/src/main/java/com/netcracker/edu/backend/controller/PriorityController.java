package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.PriorityEntity;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/priority")
public class PriorityController {

    private IDefaultOperationService<PriorityEntity> priorityService;

    private FindService<PriorityEntity> findService;

    @Autowired
    public PriorityController(IDefaultOperationService<PriorityEntity> priorityService, FindService<PriorityEntity> findService){
        this.priorityService = priorityService;
        this.findService = findService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<PriorityEntity> getAllPriority(){
       return priorityService.findAll();
    }

    @RequestMapping(value = "/{priority}", method = RequestMethod.GET)
    public PriorityEntity getByPriority(@PathVariable(name = "priority") String priority){
        return findService.findByName(priority);
    }
}
