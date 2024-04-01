package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.userappdtos.GetUserAppDto;
import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.UserAppMapper;
import com.example.thirdtask.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppService {
    private final UserAppRepository userAppRepository;
//    private final UserAppMapper userAppMapper;
//
//    @Autowired
//    public UserAppService(UserAppRepository userAppRepository, UserAppMapper userAppMapper) {
//        this.userAppRepository = userAppRepository;
//        this.userAppMapper = userAppMapper;
//    }

    @Autowired
    public UserAppService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    public List<UserApp> getAllUsers() {
        return userAppRepository.findAll();
    }

//    public List<GetUserAppDto> getAllUsers() {
//        return userAppRepository.findAll().stream().map(userAppMapper::userAppToGetUserAppDto).toList();
//    }
    public UserApp getUserById(Integer id) {
        return userAppRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
    }

    public void addUser(UserApp user) {
        userAppRepository.save(user);
    }

    public void updateUser(UserApp user) {
        var existingUser = userAppRepository.findById(user.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        userAppRepository.save(user);
    }

    public void removeUserById(Integer id) {
        var existingUser = userAppRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        userAppRepository.deleteById(id);
    }
}
