package com.netcracker.edu.controller;

import com.netcracker.edu.models.PriorityViewModel;
import com.netcracker.edu.service.PriorityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/priority")
public class PriorityDataController {

    @Autowired
    private PriorityDataService priorityDataService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<PriorityViewModel>> getAllTaskPriority(){
        return ResponseEntity.ok(priorityDataService.getAll());
    }

    @RequestMapping(value = "/{priority}", method = RequestMethod.GET)
    public ResponseEntity<PriorityViewModel> getPriorityByPriority(@PathVariable(name = "priority") String priority){
        return ResponseEntity.ok(priorityDataService.getByPriority(priority));
    }
}
