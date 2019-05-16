package com.netcracker.edu.service;

import com.netcracker.edu.models.UserDBModel;
import com.netcracker.edu.models.pageModels.PageUserDBModel;

import java.util.List;

public interface UserDataService {
    UserDBModel saveNewUser(UserDBModel user);
    List<UserDBModel> getAllUsers();
    UserDBModel getByEmail(String email);
    PageUserDBModel getPageWithoutAdmin(int page, int size);
    List<UserDBModel> getOnlyDeveloper();
    void delete(int id);
}
