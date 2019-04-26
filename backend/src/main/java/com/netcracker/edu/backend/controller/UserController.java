package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import com.netcracker.edu.backend.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
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

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity getUserByName(@PathVariable(name = "email") String email){
	    Optional<UserEntity> user = userService.findByEmail(email);
        return ResponseEntity.ok(user.get());
    }
}
