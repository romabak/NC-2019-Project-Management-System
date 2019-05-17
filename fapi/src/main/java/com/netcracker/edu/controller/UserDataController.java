package com.netcracker.edu.controller;


import com.netcracker.edu.models.DTOModels.PageUserDTOModel;
import com.netcracker.edu.models.DTOModels.UserDTOModel;
import com.netcracker.edu.models.UserDBModel;
import com.netcracker.edu.models.pageModels.PageUserDBModel;
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
        List<UserDTOModel> users = userDataService.getAllUsers().stream().map(user-> new UserDTOModel(user)).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public UserDBModel saveUser(@RequestBody UserDBModel user){
        return userDataService.saveNewUser(user);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<UserDTOModel> getByEmail(@PathVariable(name = "email") String email){
        return ResponseEntity.ok(new UserDTOModel(userDataService.getByEmail(email)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id")int id){
        userDataService.delete(id);
    }

    @RequestMapping(value = "", params = {"page", "size"}, method = RequestMethod.GET)
    public ResponseEntity<PageUserDTOModel> getPageOfUsers(@RequestParam(value = "page")int page, @RequestParam(value = "size")int size){
        PageUserDBModel pageDb = userDataService.getPageWithoutAdmin(page, size);
        PageUserDTOModel pageDto = new PageUserDTOModel(pageDb);
        return ResponseEntity.ok(pageDto);
    }

    @RequestMapping(value = "/dev", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTOModel>> getPageOfUsersWithOnlyDev(){
        List<UserDBModel> developers = this.userDataService.getOnlyDeveloper();
        List<UserDTOModel> dev = developers.stream().map(user-> new UserDTOModel(user)).collect(Collectors.toList());
        return ResponseEntity.ok(dev);
    }

}
