package com.netcracker.name.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserViewModel {

    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private int roleId;

    public UserViewModel(){

    }

    public UserViewModel(String firstName, String secondName, String email, String password, int role){
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
	    this.roleId = role;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public String getSecond_name() {
        return secondName;
    }

    public void setSecond_name(String secondName) {
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

    public int getRole_id() {
        return roleId;
    }

    public void setRole_id(int role) {
        this.roleId = role;
   }

}
