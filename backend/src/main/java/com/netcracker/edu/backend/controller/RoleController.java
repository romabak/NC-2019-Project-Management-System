package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.RoleEntity;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private IDefaultOperationService<RoleEntity> roleService;

    private FindService<RoleEntity> findService;

    @Autowired
    public RoleController(IDefaultOperationService<RoleEntity> roleService, FindService<RoleEntity> findService) {
        this.roleService = roleService;
        this.findService = findService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<RoleEntity> getAllUserRole(){
        return roleService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public RoleEntity saveUserRole(@RequestBody RoleEntity role){
        return roleService.save(role);
    }

    @RequestMapping(value = "/{role}", method = RequestMethod.GET)
    public RoleEntity getByRole(@PathVariable(name = "role") String role){
        return findService.findByName(role);
    }
}
