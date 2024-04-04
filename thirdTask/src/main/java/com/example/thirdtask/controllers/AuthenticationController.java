package com.example.thirdtask.controllers;

import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<Object> signIn(@RequestParam String email, @RequestParam String password) {
        var authenticationResponse = authenticationService.signIn(email, password);

        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<Object> signUp(@RequestBody UserApp userApp) {
        var authenticationResponse = authenticationService.signUp(userApp);

        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }
}
