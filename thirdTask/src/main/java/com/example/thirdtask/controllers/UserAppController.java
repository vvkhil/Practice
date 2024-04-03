package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.userappdtos.GetUserAppDto;
import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.services.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAppController {
    private final UserAppService userAppService;

    @Autowired
    public UserAppController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<GetUserAppDto>> getUsers() {
        var users = userAppService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @GetMapping("/users")
//    public ResponseEntity<List<UserApp>> getUsers() {
//        var users = userAppService.getAllUsers();
//
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }

    @GetMapping("/users/{id}")
    public ResponseEntity<GetUserAppDto> getUserById(@PathVariable Integer id) {
        var user = userAppService.getUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(UserApp user) {
        userAppService.addUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<Object> updateUser(UserApp user) {
        userAppService.updateUser(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> removeUserById(@PathVariable Integer id) {
        userAppService.removeUserById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
