package com.netcracker.name.models.DTOModels;

import com.netcracker.name.models.UserDBModel;

public class UserDTOModel {

    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String role;

    public UserDTOModel(){

    }

    public UserDTOModel(UserDBModel user){
        this(
                user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().getRole()
        );
    }

    public UserDTOModel(int id, String firstName, String secondName, String email, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
