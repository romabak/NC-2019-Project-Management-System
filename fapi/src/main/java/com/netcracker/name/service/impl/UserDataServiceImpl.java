package com.netcracker.name.service.impl;

import com.netcracker.name.models.UserDBModel;
import com.netcracker.name.service.UserDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public UserDBModel saveNewUser(UserDBModel user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, UserDBModel.class).getBody();
    }

    @Override
    public List<UserDBModel> getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        UserDBModel[] userDBModelsResponse = restTemplate.getForObject(backendServerUrl + "/api/user", UserDBModel[].class);
        return userDBModelsResponse == null ? Collections.emptyList() : Arrays.asList(userDBModelsResponse);
    }

    @Override
    public UserDBModel getByEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user/" + email, UserDBModel.class);
    }


}
