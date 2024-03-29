package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppService {
    @Autowired
    private UserAppRepository userAppRepository;

    public List<UserApp> getAllUsersApp() {
        return userAppRepository.findAll();
    }

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
