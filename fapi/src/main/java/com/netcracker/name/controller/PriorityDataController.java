package com.netcracker.name.controller;

import com.netcracker.name.models.PriorityViewModel;
import com.netcracker.name.service.PriorityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba")
public class PriorityDataController {

    @Autowired
    private PriorityDataService priorityDataService;

    @RequestMapping("/priority")
    public ResponseEntity<List<PriorityViewModel>> getAllTaskPriority(){
        return ResponseEntity.ok(priorityDataService.getAll());
    }
}
