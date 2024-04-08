package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.userappdtos.UserAppDto;
import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.services.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class UserAppController {
    private final UserAppService userAppService;

    @Autowired
    public UserAppController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserAppDto>> getUsers() {
        var users = userAppService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserAppDto> getUserById(@PathVariable Integer id) {
        var user = userAppService.getUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Object> addUser(UserApp user) {
        userAppService.addUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/users")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Object> updateUser(@RequestBody UserApp user, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        userAppService.updateUser(user, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Object> removeUserById(@PathVariable Integer id, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        userAppService.removeUserById(id, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/roles/{id}/users")
    public ResponseEntity<List<UserAppDto>> getUserAppByRoleId(@PathVariable Integer id) {
        var users = userAppService.getUserAppByRoleId(id);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
