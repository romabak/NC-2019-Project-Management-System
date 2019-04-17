package com.netcracker.name.controller;


import com.netcracker.name.models.UserViewModel;
import com.netcracker.name.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserDataController {

    private UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService){
        this.userDataService = userDataService;
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST, produces = "application/json")
    public UserViewModel saveUser(@RequestBody UserViewModel user){
        return userDataService.saveNewUser(user);
    }
}
