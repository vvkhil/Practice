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

    private final UserAppMapper userAppMapper;

    @Autowired
    public UserAppService(UserAppRepository userAppRepository, UserAppMapper userAppMapper) {
        this.userAppRepository = userAppRepository;
        this.userAppMapper = userAppMapper;
    }

    public List<GetUserAppDto> getAllUsers() {
        return userAppRepository.findAll().stream().map(userAppMapper::userAppToUserAppDto).toList();
    }

    public GetUserAppDto getUserById(Integer id) {
        var userApp = userAppRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return userAppMapper.userAppToUserAppDto(userApp);
    }

    public UserApp getUserByEmail(String email) {
        return userAppRepository.findByEmail(email).get();
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
