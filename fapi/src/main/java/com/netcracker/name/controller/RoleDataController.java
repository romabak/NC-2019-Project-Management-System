package com.netcracker.name.controller;

import com.netcracker.name.models.RoleViewModel;
import com.netcracker.name.service.RoleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba")
public class RoleDataController {

    @Autowired
    private RoleDataService roleDataService;

    @RequestMapping("/role")
    public ResponseEntity<List<RoleViewModel>> getAllUserRole(){
        return ResponseEntity.ok(roleDataService.getAll());
    }
}
