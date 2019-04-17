package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.service.UserService;
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
	    return userService.findAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity saveNewUser(@RequestBody UserEntity user){
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") int id){
	    userService.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserByID(@PathVariable(name = "id") Integer id){
	    Optional<UserEntity> user = userService.findUserById(id);
	    if(user.isPresent()){
		    return ResponseEntity.ok(user.get());
	    } else {
		    return ResponseEntity.notFound().build();
	    }
    } 
}
