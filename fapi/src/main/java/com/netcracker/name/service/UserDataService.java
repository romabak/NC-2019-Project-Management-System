package com.netcracker.name.service;

import com.netcracker.name.models.UserDBModel;

import java.util.List;

public interface UserDataService {
    UserDBModel saveNewUser(UserDBModel user);
    List<UserDBModel> getAllUsers();
    UserDBModel getByEmail(String email);
}
