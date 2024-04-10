package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.userappdtos.UserAppDto;
import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.exceptions.AlreadyExistsException;
import com.example.thirdtask.exceptions.ForbiddenException;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.UserAppMapper;
import com.example.thirdtask.repositories.RoleRepository;
import com.example.thirdtask.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserAppService {
    private final UserAppRepository userAppRepository;
    private final UserAppMapper userAppMapper;
    private final RoleRepository roleRepository;

    @Autowired
    public UserAppService(UserAppRepository userAppRepository, UserAppMapper userAppMapper,
                          RoleRepository roleRepository) {
        this.userAppRepository = userAppRepository;
        this.userAppMapper = userAppMapper;
        this.roleRepository = roleRepository;
    }

    public List<UserAppDto> getAllUsers() {
        return userAppRepository.findAll().stream().map(userAppMapper::toUserDto).toList();
    }

    public UserAppDto getUserById(Integer id) {
        var user = userAppRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return userAppMapper.toUserDto(user);
    }

    public UserApp addUser(UserApp user) {
        var optionalUser = userAppRepository.findByEmail(user.getEmail());

        if (optionalUser.isPresent()) {
            throw new AlreadyExistsException(Constants.CONFLICT);
        }

        var role = roleRepository.findById(3).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        user.setRole(role);

        userAppRepository.save(user);

        return user;
    }

    public void updateUser(UserApp user, Integer authenticatedUserId) {

        if (!Objects.equals(authenticatedUserId, user.getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        var existingUser = userAppRepository.findById(user.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        userAppRepository.save(user);
    }

    public void removeUserById(Integer id, Integer authenticatedUserId) {

        if (!Objects.equals(authenticatedUserId, id)) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }


        var existingUser = userAppRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        userAppRepository.deleteById(id);
    }

    public UserAppDto getUserByEmailAndPassword(String email, String password) {
        var user = userAppRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new ForbiddenException("Invalid email or password"));

        return userAppMapper.toUserDto(user);
    }

    public List<UserAppDto> getUserAppByRoleId(Integer roleId) {
        return userAppRepository.findByRoleId(roleId).stream().map(userAppMapper::toUserDto).toList();
    }

}
