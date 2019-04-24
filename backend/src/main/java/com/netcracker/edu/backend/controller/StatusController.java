package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.StatusEntity;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private IDefaultOperationService<StatusEntity> statusService;

    private FindService<StatusEntity> findService;

    @Autowired
    public StatusController(IDefaultOperationService<StatusEntity> statusService, FindService<StatusEntity> findService) {
        this.statusService = statusService;
        this.findService = findService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<StatusEntity> getAllTaskStatus(){
        return statusService.findAll();
    }

    @RequestMapping(value = "/{status}", method = RequestMethod.GET)
    public StatusEntity getByStatus(@PathVariable(name = "status") String status){
        return findService.findByName(status);
    }
}
