package com.netcracker.edu.service;

import com.netcracker.edu.models.UserDBModel;

import java.util.List;

public interface UserDataService {
    UserDBModel saveNewUser(UserDBModel user);
    List<UserDBModel> getAllUsers();
    UserDBModel getByEmail(String email);
}
