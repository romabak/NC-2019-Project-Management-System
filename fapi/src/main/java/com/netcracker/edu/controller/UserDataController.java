package com.netcracker.edu.controller;


import com.netcracker.edu.models.DTOModels.UserDTOModel;
import com.netcracker.edu.models.UserDBModel;
import com.netcracker.edu.service.RoleDataService;
import com.netcracker.edu.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserDataController {

    private UserDataService userDataService;
    private RoleDataService roleDataService;

    @Autowired
    public UserDataController(UserDataService userDataService, RoleDataService roleDataService){
        this.userDataService = userDataService;
        this.roleDataService = roleDataService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTOModel>> getAllUsers(){
        List<UserDBModel> users = userDataService.getAllUsers();
        List<UserDTOModel> usersDto = users.stream().map(user-> new UserDTOModel(user)).collect(Collectors.toList());
        return ResponseEntity.ok(usersDto);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public UserDBModel saveUser(@RequestBody UserDTOModel user){
        return userDataService.saveNewUser(convertToEntity(user));
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<UserDBModel> getByEmail(@PathVariable(name = "email") String email){
        return ResponseEntity.ok(userDataService.getByEmail(email));
    }

    private UserDBModel convertToEntity(UserDTOModel dtoModel){
        UserDBModel model = new UserDBModel();
        model.setFirstName(dtoModel.getFirstName());
        model.setSecondName(dtoModel.getSecondName());
        model.setEmail(dtoModel.getEmail());
        System.out.println("password = " + dtoModel.getPassword());
        model.setPassword(dtoModel.getPassword());
        model.setRole(roleDataService.getByRole(dtoModel.getRole()));
        return model;
    }

}
