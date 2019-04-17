package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.StatusEntity;
import com.netcracker.edu.backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService){
        this.statusService = statusService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<StatusEntity> getAllTaskStatus(){
        return statusService.getAllTaskStatus();
    }
}
