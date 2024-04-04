package com.example.thirdtask.services;

import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.responses.AuthenticationResponse;
import com.example.thirdtask.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserAppService userAppService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthenticationService(UserAppService userAppService,
                                 JwtUtil jwtUtil) {
        this.userAppService = userAppService;
        this.jwtUtil = jwtUtil;
    }

    public AuthenticationResponse signIn(String email, String password) {
        var user = userAppService.getUserByEmailAndPassword(email, password);
        var token = jwtUtil.generateToken(user.getId());

        return new AuthenticationResponse(user.getId(), token);
    }

    public AuthenticationResponse signUp(UserApp userApp) {
        var user = userAppService.addUser(userApp);
        var token = jwtUtil.generateToken(user.getId());

        return new AuthenticationResponse(user.getId(), token);
    }
}