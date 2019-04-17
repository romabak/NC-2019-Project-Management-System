package com.netcracker.name.service;

import com.netcracker.name.models.UserViewModel;

public interface UserDataService {
    UserViewModel saveNewUser(UserViewModel user);
}
