package com.example.thirdtask.controllers;


import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.services.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAppController {
    @Autowired
    UserAppService userAppService;

    @GetMapping("/usersapp")
    public List<UserApp> getAllUserApp()
    {
        return userAppService.getAllUsersApp();
    }
}
