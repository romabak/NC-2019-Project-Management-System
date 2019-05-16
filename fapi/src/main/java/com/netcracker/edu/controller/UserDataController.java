package com.netcracker.edu.controller;


import com.netcracker.edu.models.UserDBModel;
import com.netcracker.edu.models.pageModels.PageUserDBModel;
import com.netcracker.edu.service.RoleDataService;
import com.netcracker.edu.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<UserDBModel>> getAllUsers(){
        List<UserDBModel> users = userDataService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public UserDBModel saveUser(@RequestBody UserDBModel user){
        return userDataService.saveNewUser(user);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<UserDBModel> getByEmail(@PathVariable(name = "email") String email){
        return ResponseEntity.ok(userDataService.getByEmail(email));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id")int id){
        userDataService.delete(id);
    }

    @RequestMapping(value = "", params = {"page", "size"}, method = RequestMethod.GET)
    public ResponseEntity<PageUserDBModel> getPageOfUsers(@RequestParam(value = "page")int page, @RequestParam(value = "size")int size){
        PageUserDBModel pageDb = userDataService.getPageWithoutAdmin(page, size);
        return ResponseEntity.ok(pageDb);
    }

    @RequestMapping(value = "/dev", method = RequestMethod.GET)
    public ResponseEntity<List<UserDBModel>> getPageOfUsersWithOnlyDev(){
        List<UserDBModel> developers = this.userDataService.getOnlyDeveloper();
        return ResponseEntity.ok(developers);
    }

}
