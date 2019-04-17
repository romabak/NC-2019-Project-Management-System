package com.netcracker.name.service.impl;

import com.netcracker.name.models.UserViewModel;
import com.netcracker.name.service.UserDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public UserViewModel saveNewUser(UserViewModel user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, UserViewModel.class).getBody();
    }
}
