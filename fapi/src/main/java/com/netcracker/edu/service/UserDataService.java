package com.netcracker.edu.service;

import com.netcracker.edu.models.DTOModels.PageUserDTOModel;
import com.netcracker.edu.models.UserDBModel;
import com.netcracker.edu.models.pageModels.PageUserDBModel;

import java.util.List;

public interface UserDataService {
    UserDBModel saveNewUser(UserDBModel user);
    List<UserDBModel> getAllUsers();
    UserDBModel getByEmail(String email);
    PageUserDBModel getPageUserByFilter(int page, int size, String filter);
    List<UserDBModel> getOnlyDeveloper();
    void delete(int id);
}
