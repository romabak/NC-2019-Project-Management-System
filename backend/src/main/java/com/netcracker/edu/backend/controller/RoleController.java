package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.RoleEntity;
import com.netcracker.edu.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<RoleEntity> getAllUserRole(){
        return roleService.getAllUserRole();
    }

    @RequestMapping(method = RequestMethod.POST)
    public RoleEntity saveUserRole(@RequestBody RoleEntity role){
        return roleService.saveUserRole(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoleEntity> getRoleById(@PathVariable(name = "id") Integer id){
        Optional<RoleEntity> role = roleService.getRoleById(id);
        if(role.isPresent()){
            return ResponseEntity.ok(role.get());
        } else {
        return ResponseEntity.notFound().build();
        }
    }
}
