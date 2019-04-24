package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private IDefaultOperationService<UserEntity> userService;
    private FindService<UserEntity> findService;

    @Autowired
    public UserController(FindService<UserEntity> findService, IDefaultOperationService<UserEntity> userService){
        this.userService = userService;
        this.findService = findService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserEntity> getAllUser(){
	    return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity saveNewUser(@RequestBody UserEntity user){
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") int id){
	    userService.delete(id);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity getUserByName(@PathVariable(name = "name") String name){
	    UserEntity user = findService.findByName(name);
        return ResponseEntity.ok(user);
    }
}
