package com.netcracker.name.controller;

import com.netcracker.name.models.RoleViewModel;
import com.netcracker.name.service.RoleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleDataController {

    @Autowired
    private RoleDataService roleDataService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<RoleViewModel>> getAllUserRole(){
        return ResponseEntity.ok(roleDataService.getAll());
    }
}
