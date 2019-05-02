package com.netcracker.edu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDBModel {

    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private RoleViewModel role;

    public UserDBModel(){

    }

    public UserDBModel(int id, String firstName, String secondName, String email, String password, RoleViewModel role){
	    this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
	    this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleViewModel getRole() {
        return role;
    }

    public void setRole(RoleViewModel role) {
        this.role = role;
   }

}
