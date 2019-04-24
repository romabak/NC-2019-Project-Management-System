package com.netcracker.name.controller;

import com.netcracker.name.models.StatusViewModel;
import com.netcracker.name.service.StatusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusDataController {

    @Autowired
    private StatusDataService statusDataService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<StatusViewModel>> getAllTaskStatus(){
        return ResponseEntity.ok(statusDataService.getAll());
    }
}
