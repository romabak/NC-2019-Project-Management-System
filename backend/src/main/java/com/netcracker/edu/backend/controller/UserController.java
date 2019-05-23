package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        System.out.println(user.toString());
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

    @RequestMapping(value = "", params = {"size", "page", "role"}, method = RequestMethod.GET)
    public Iterable<UserEntity> getPageWithoutUsersWithRole(@RequestParam(value = "page") int page,
                                                            @RequestParam(value = "size") int size,
                                                            @RequestParam(value = "role") String role,
                                                            @RequestParam(value = "filter", required = false) String filter){
        Pageable pageable = PageRequest.of(page, size);
        if(filter == null){
            return this.userService.findAllWithout(role, pageable);
        } else {
            return this.userService.findAllByFilter(role, filter, pageable);
        }
    }

    @RequestMapping(value = "", params = {"role"}, method = RequestMethod.GET)
    public Iterable<UserEntity> getPageWithOneRole(@RequestParam(value = "role") String role){
        return this.userService.findAllByRole(role);
    }
}
