package com.example.thirdtask.services;

import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppService {
    @Autowired
    UserAppRepository userAppRepository;

    public List<UserApp> getAllUsersApp() {
        return userAppRepository.findAll();
    }
}
