package com.netcracker.edu.models.DTOModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.models.RoleViewModel;
import com.netcracker.edu.models.UserDBModel;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTOModel {

    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private RoleViewModel role;

    public UserDTOModel(){

    }

    public UserDTOModel(int id, String firstName, String secondName, String email, RoleViewModel role){
	    this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
	    this.role = role;
    }

    public UserDTOModel(UserDBModel user){
        this(user.getId(), user.getFirstName(), user.getSecondName(), user.getEmail(), user.getRole());
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleViewModel getRole() {
        return role;
    }

    public void setRole(RoleViewModel role) {
        this.role = role;
   }

    @Override
    public String toString() {
        return "UserDBModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role.toString() +
                '}';
    }
}
